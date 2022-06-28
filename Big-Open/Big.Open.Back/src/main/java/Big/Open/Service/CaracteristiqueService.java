package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Caracteristique;
import big.open.payload.request.CaracteristiqueRequest;
import big.open.payload.response.CaracteristiqueResponse;
import big.open.payload.response.CaracteristiqueResponseFindById;
import big.open.payload.response.CaracteristiqueResponseSave;
import big.open.payload.response.error.CaracteristiqueResponseError;
import big.open.repository.CaracteristiqueRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CaracteristiqueService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CaracteristiqueRepository caracteristiqueRepository;
	public CaracteristiqueResponseFindById findById(Integer id)
	{
		Optional<Caracteristique> caracteristique = caracteristiqueRepository.findById(id);
		if(caracteristique.isPresent())
		{
			CaracteristiqueResponse caracteristiqueResponse = ObjectMapperUtility.map(caracteristique.get(),CaracteristiqueResponse.class);
			return new CaracteristiqueResponseFindById(caracteristiqueResponse);
		}
		return new CaracteristiqueResponseFindById("Non trouvé");
	}
	public CaracteristiqueResponseSave save(CaracteristiqueRequest caracteristiqueRequest)
	{
		CaracteristiqueResponseError caracteristiqueResponseError = checkCaracteristiqueResponseError(caracteristiqueRequest);
		if(caracteristiqueResponseError.isHave_error())
		{
			return new CaracteristiqueResponseSave(caracteristiqueResponseError);
		}
		else
		{
			try
			{
				Caracteristique caracteristique = caracteristiqueRepository.save(ObjectMapperUtility.map(caracteristiqueRequest, Caracteristique.class));
				return  new CaracteristiqueResponseSave(ObjectMapperUtility.map(caracteristique, CaracteristiqueResponse.class));
			}
			catch(Exception e)
			{
				caracteristiqueResponseError.setHave_error(true);
				return  new CaracteristiqueResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var caracteristique = caracteristiqueRepository.findById(id);
			caracteristiqueRepository.save(caracteristique.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CaracteristiqueResponseError checkCaracteristiqueResponseError (CaracteristiqueRequest caracteristiqueRequest)
	{
		CaracteristiqueResponseError caracteristiqueResponseError = new CaracteristiqueResponseError();
		caracteristiqueResponseError.setHave_error(false);
		if(Utility.isEmpty(caracteristiqueRequest.getId().toString()) )
		{
			caracteristiqueRequest.setId(-1);
		}
		//if(Utility.isEmpty(caracteristiqueRequest.get()) )
		//{
				//caracteristiqueResponseError.setHave_error(true);
				//caracteristiqueResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return caracteristiqueResponseError;
	}
}
