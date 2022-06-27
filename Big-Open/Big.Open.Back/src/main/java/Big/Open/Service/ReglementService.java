package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Reglement;
import big.open.payload.request.ReglementRequest;
import big.open.payload.response.ReglementResponse;
import big.open.payload.response.ReglementResponseFindById;
import big.open.payload.response.ReglementResponseSave;
import big.open.payload.response.error.ReglementResponseError;
import big.open.repository.ReglementRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ReglementService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ReglementRepository reglementRepository;
	public ReglementResponseFindById findById(Integer id)
	{
		Optional<Reglement> reglement = reglementRepository.findById(id);
		if(reglement.isPresent())
		{
			ReglementResponse reglementResponse = ObjectMapperUtility.map(reglement.get(),ReglementResponse.class);
			return new ReglementResponseFindById(reglementResponse);
		}
		return new ReglementResponseFindById("Non trouvé");
	}
	public ReglementResponseSave save(ReglementRequest reglementRequest)
	{
		ReglementResponseError reglementResponseError = checkReglementResponseError(reglementRequest);
		if(reglementResponseError.isHave_error())
		{
			return new ReglementResponseSave(reglementResponseError);
		}
		else
		{
			try
			{
				Reglement reglement = reglementRepository.save(ObjectMapperUtility.map(reglementRequest, Reglement.class));
				return  new ReglementResponseSave(ObjectMapperUtility.map(reglement, ReglementResponse.class));
			}
			catch(Exception e)
			{
				reglementResponseError.setHave_error(true);
				return  new ReglementResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var reglement = reglementRepository.findById(id);
			reglementRepository.save(reglement.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ReglementResponseError checkReglementResponseError (ReglementRequest reglementRequest)
	{
		ReglementResponseError reglementResponseError = new ReglementResponseError();
		reglementResponseError.setHave_error(false);
		//if(Utility.isEmpty(reglementRequest.get()) )
		//{
				//reglementResponseError.setHave_error(true);
				//reglementResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return reglementResponseError;
	}
}
