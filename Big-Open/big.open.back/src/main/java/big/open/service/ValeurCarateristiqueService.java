package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.ValeurCarateristique;
import big.open.payload.request.ValeurCarateristiqueRequest;
import big.open.payload.response.ValeurCarateristiqueResponse;
import big.open.payload.response.ValeurCarateristiqueResponseFindById;
import big.open.payload.response.ValeurCarateristiqueResponseSave;
import big.open.payload.response.error.ValeurCarateristiqueResponseError;
import big.open.repository.ValeurCarateristiqueRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ValeurCarateristiqueService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ValeurCarateristiqueRepository valeurCarateristiqueRepository;
	public ValeurCarateristiqueResponseFindById findById(Integer id)
	{
		Optional<ValeurCarateristique> valeurCarateristique = valeurCarateristiqueRepository.findById(id);
		if(valeurCarateristique.isPresent())
		{
			ValeurCarateristiqueResponse valeurCarateristiqueResponse = ObjectMapperUtility.map(valeurCarateristique.get(),ValeurCarateristiqueResponse.class);
			return new ValeurCarateristiqueResponseFindById(valeurCarateristiqueResponse);
		}
		return new ValeurCarateristiqueResponseFindById("Non trouvé");
	}
	public ValeurCarateristiqueResponseSave save(ValeurCarateristiqueRequest valeurCarateristiqueRequest)
	{
		ValeurCarateristiqueResponseError valeurCarateristiqueResponseError = checkValeurCarateristiqueResponseError(valeurCarateristiqueRequest);
		if(valeurCarateristiqueResponseError.isHave_error())
		{
			return new ValeurCarateristiqueResponseSave(valeurCarateristiqueResponseError);
		}
		else
		{
			try
			{
				ValeurCarateristique valeurCarateristique = valeurCarateristiqueRepository.save(ObjectMapperUtility.map(valeurCarateristiqueRequest, ValeurCarateristique.class));
				return  new ValeurCarateristiqueResponseSave(ObjectMapperUtility.map(valeurCarateristique, ValeurCarateristiqueResponse.class));
			}
			catch(Exception e)
			{
				valeurCarateristiqueResponseError.setHave_error(true);
				return  new ValeurCarateristiqueResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var valeurCarateristique = valeurCarateristiqueRepository.findById(id);
			valeurCarateristiqueRepository.save(valeurCarateristique.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ValeurCarateristiqueResponseError checkValeurCarateristiqueResponseError (ValeurCarateristiqueRequest valeurCarateristiqueRequest)
	{
		ValeurCarateristiqueResponseError valeurCarateristiqueResponseError = new ValeurCarateristiqueResponseError();
		valeurCarateristiqueResponseError.setHave_error(false);
		if(Utility.isEmpty(valeurCarateristiqueRequest.getId().toString()) )
		{
			valeurCarateristiqueRequest.setId(-1);
		}
		//if(Utility.isEmpty(valeurCarateristiqueRequest.get()) )
		//{
				//valeurCarateristiqueResponseError.setHave_error(true);
				//valeurCarateristiqueResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return valeurCarateristiqueResponseError;
	}
}
