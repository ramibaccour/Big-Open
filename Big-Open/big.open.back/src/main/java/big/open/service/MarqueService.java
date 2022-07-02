package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Marque;
import big.open.payload.request.MarqueRequest;
import big.open.payload.response.MarqueResponse;
import big.open.payload.response.MarqueResponseFindById;
import big.open.payload.response.MarqueResponseSave;
import big.open.payload.response.error.MarqueResponseError;
import big.open.repository.MarqueRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class MarqueService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MarqueRepository marqueRepository;
	public MarqueResponseFindById findById(Integer id)
	{
		Optional<Marque> marque = marqueRepository.findById(id);
		if(marque.isPresent())
		{
			MarqueResponse marqueResponse = ObjectMapperUtility.map(marque.get(),MarqueResponse.class);
			return new MarqueResponseFindById(marqueResponse);
		}
		return new MarqueResponseFindById("");
	}
	public MarqueResponseSave save(MarqueRequest marqueRequest)
	{
		MarqueResponseError marqueResponseError = checkMarqueResponseError(marqueRequest);
		if(marqueResponseError.isHaveError())
		{
			return new MarqueResponseSave(marqueResponseError);
		}
		else
		{
			try
			{
				Marque marque = marqueRepository.save(ObjectMapperUtility.map(marqueRequest, Marque.class));
				return  new MarqueResponseSave(ObjectMapperUtility.map(marque, MarqueResponse.class));
			}
			catch(Exception e)
			{
				marqueResponseError.setHaveError(true);
				return  new MarqueResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var marque = marqueRepository.findById(id);
			marqueRepository.save(marque.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private MarqueResponseError checkMarqueResponseError (MarqueRequest marqueRequest)
	{
		MarqueResponseError marqueResponseError = new MarqueResponseError();
		marqueResponseError.setHaveError(false);
		if(Utility.isEmpty(marqueRequest.getId()) )
		{
			marqueRequest.setId(-1);
		}
		//if(Utility.isEmpty(marqueRequest.get()) )
		//{
				//marqueResponseError.setHaveError(true);
				//marqueResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return marqueResponseError;
	}
}
