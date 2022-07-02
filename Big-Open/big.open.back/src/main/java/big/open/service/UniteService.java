package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Unite;
import big.open.payload.request.UniteRequest;
import big.open.payload.response.UniteResponse;
import big.open.payload.response.UniteResponseFindById;
import big.open.payload.response.UniteResponseSave;
import big.open.payload.response.error.UniteResponseError;
import big.open.repository.UniteRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UniteService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UniteRepository uniteRepository;
	public UniteResponseFindById findById(Integer id)
	{
		Optional<Unite> unite = uniteRepository.findById(id);
		if(unite.isPresent())
		{
			UniteResponse uniteResponse = ObjectMapperUtility.map(unite.get(),UniteResponse.class);
			return new UniteResponseFindById(uniteResponse);
		}
		return new UniteResponseFindById("Non trouvé");
	}
	public UniteResponseSave save(UniteRequest uniteRequest)
	{
		UniteResponseError uniteResponseError = checkUniteResponseError(uniteRequest);
		if(uniteResponseError.isHave_error())
		{
			return new UniteResponseSave(uniteResponseError);
		}
		else
		{
			try
			{
				Unite unite = uniteRepository.save(ObjectMapperUtility.map(uniteRequest, Unite.class));
				return  new UniteResponseSave(ObjectMapperUtility.map(unite, UniteResponse.class));
			}
			catch(Exception e)
			{
				uniteResponseError.setHave_error(true);
				return  new UniteResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var unite = uniteRepository.findById(id);
			uniteRepository.save(unite.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private UniteResponseError checkUniteResponseError (UniteRequest uniteRequest)
	{
		UniteResponseError uniteResponseError = new UniteResponseError();
		uniteResponseError.setHave_error(false);
		if(Utility.isEmpty(uniteRequest.getId().toString()) )
		{
			uniteRequest.setId(-1);
		}
		//if(Utility.isEmpty(uniteRequest.get()) )
		//{
				//uniteResponseError.setHave_error(true);
				//uniteResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return uniteResponseError;
	}
}
