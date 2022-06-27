package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Monnaie;
import big.open.payload.request.MonnaieRequest;
import big.open.payload.response.MonnaieResponse;
import big.open.payload.response.MonnaieResponseFindById;
import big.open.payload.response.MonnaieResponseSave;
import big.open.payload.response.error.MonnaieResponseError;
import big.open.repository.MonnaieRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class MonnaieService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MonnaieRepository monnaieRepository;
	public MonnaieResponseFindById findById(Integer id)
	{
		Optional<Monnaie> monnaie = monnaieRepository.findById(id);
		if(monnaie.isPresent())
		{
			MonnaieResponse monnaieResponse = ObjectMapperUtility.map(monnaie.get(),MonnaieResponse.class);
			return new MonnaieResponseFindById(monnaieResponse);
		}
		return new MonnaieResponseFindById("Non trouvé");
	}
	public MonnaieResponseSave save(MonnaieRequest monnaieRequest)
	{
		MonnaieResponseError monnaieResponseError = checkMonnaieResponseError(monnaieRequest);
		if(monnaieResponseError.isHave_error())
		{
			return new MonnaieResponseSave(monnaieResponseError);
		}
		else
		{
			try
			{
				Monnaie monnaie = monnaieRepository.save(ObjectMapperUtility.map(monnaieRequest, Monnaie.class));
				return  new MonnaieResponseSave(ObjectMapperUtility.map(monnaie, MonnaieResponse.class));
			}
			catch(Exception e)
			{
				monnaieResponseError.setHave_error(true);
				return  new MonnaieResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var monnaie = monnaieRepository.findById(id);
			monnaieRepository.save(monnaie.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private MonnaieResponseError checkMonnaieResponseError (MonnaieRequest monnaieRequest)
	{
		MonnaieResponseError monnaieResponseError = new MonnaieResponseError();
		monnaieResponseError.setHave_error(false);
		//if(Utility.isEmpty(monnaieRequest.get()) )
		//{
				//monnaieResponseError.setHave_error(true);
				//monnaieResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return monnaieResponseError;
	}
}
