package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Societe;
import big.open.payload.request.SocieteRequest;
import big.open.payload.response.SocieteResponse;
import big.open.payload.response.SocieteResponseFindById;
import big.open.payload.response.SocieteResponseSave;
import big.open.payload.response.error.SocieteResponseError;
import big.open.repository.SocieteRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class SocieteService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	SocieteRepository societeRepository;
	public SocieteResponseFindById findById(Integer id)
	{
		Optional<Societe> societe = societeRepository.findById(id);
		if(societe.isPresent())
		{
			SocieteResponse societeResponse = ObjectMapperUtility.map(societe.get(),SocieteResponse.class);
			return new SocieteResponseFindById(societeResponse);
		}
		return new SocieteResponseFindById("Non trouv�");
	}
	public SocieteResponseSave save(SocieteRequest societeRequest)
	{
		SocieteResponseError societeResponseError = checkSocieteResponseError(societeRequest);
		if(societeResponseError.isHave_error())
		{
			return new SocieteResponseSave(societeResponseError);
		}
		else
		{
			try
			{
				Societe societe = societeRepository.save(ObjectMapperUtility.map(societeRequest, Societe.class));
				return  new SocieteResponseSave(ObjectMapperUtility.map(societe, SocieteResponse.class));
			}
			catch(Exception e)
			{
				societeResponseError.setHave_error(true);
				return  new SocieteResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var societe = societeRepository.findById(id);
			if(societe.get().getIsDeleted() == 0)
				societe.get().setIsDeleted(1);
			else
				societe.get().setIsDeleted(0);
			societeRepository.save(societe.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private SocieteResponseError checkSocieteResponseError (SocieteRequest societeRequest)
	{
		SocieteResponseError societeResponseError = new SocieteResponseError();
		societeResponseError.setHave_error(false);
		//if(Utility.isEmpty(societeRequest.get()) )
		//{
				//societeResponseError.setHave_error(true);
				//societeResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return societeResponseError;
	}
}