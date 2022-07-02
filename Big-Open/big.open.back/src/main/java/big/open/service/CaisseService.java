package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Caisse;
import big.open.payload.request.CaisseRequest;
import big.open.payload.response.CaisseResponse;
import big.open.payload.response.CaisseResponseFindById;
import big.open.payload.response.CaisseResponseSave;
import big.open.payload.response.error.CaisseResponseError;
import big.open.repository.CaisseRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CaisseService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CaisseRepository caisseRepository;
	public CaisseResponseFindById findById(Integer id)
	{
		Optional<Caisse> caisse = caisseRepository.findById(id);
		if(caisse.isPresent())
		{
			CaisseResponse caisseResponse = ObjectMapperUtility.map(caisse.get(),CaisseResponse.class);
			return new CaisseResponseFindById(caisseResponse);
		}
		return new CaisseResponseFindById("Non trouvé");
	}
	public CaisseResponseSave save(CaisseRequest caisseRequest)
	{
		CaisseResponseError caisseResponseError = checkCaisseResponseError(caisseRequest);
		if(caisseResponseError.isHave_error())
		{
			return new CaisseResponseSave(caisseResponseError);
		}
		else
		{
			try
			{
				Caisse caisse = caisseRepository.save(ObjectMapperUtility.map(caisseRequest, Caisse.class));
				return  new CaisseResponseSave(ObjectMapperUtility.map(caisse, CaisseResponse.class));
			}
			catch(Exception e)
			{
				caisseResponseError.setHave_error(true);
				return  new CaisseResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var caisse = caisseRepository.findById(id);
			caisseRepository.save(caisse.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CaisseResponseError checkCaisseResponseError (CaisseRequest caisseRequest)
	{
		CaisseResponseError caisseResponseError = new CaisseResponseError();
		caisseResponseError.setHave_error(false);
		if(Utility.isEmpty(caisseRequest.getId().toString()) )
		{
			caisseRequest.setId(-1);
		}
		//if(Utility.isEmpty(caisseRequest.get()) )
		//{
				//caisseResponseError.setHave_error(true);
				//caisseResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return caisseResponseError;
	}
}
