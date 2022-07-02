package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Coordonnee;
import big.open.payload.request.CoordonneeRequest;
import big.open.payload.response.CoordonneeResponse;
import big.open.payload.response.CoordonneeResponseFindById;
import big.open.payload.response.CoordonneeResponseSave;
import big.open.payload.response.error.CoordonneeResponseError;
import big.open.repository.CoordonneeRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CoordonneeService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CoordonneeRepository coordonneeRepository;
	public CoordonneeResponseFindById findById(Integer id)
	{
		Optional<Coordonnee> coordonnee = coordonneeRepository.findById(id);
		if(coordonnee.isPresent())
		{
			CoordonneeResponse coordonneeResponse = ObjectMapperUtility.map(coordonnee.get(),CoordonneeResponse.class);
			return new CoordonneeResponseFindById(coordonneeResponse);
		}
		return new CoordonneeResponseFindById("Non trouvé");
	}
	public CoordonneeResponseSave save(CoordonneeRequest coordonneeRequest)
	{
		CoordonneeResponseError coordonneeResponseError = checkCoordonneeResponseError(coordonneeRequest);
		if(coordonneeResponseError.isHave_error())
		{
			return new CoordonneeResponseSave(coordonneeResponseError);
		}
		else
		{
			try
			{
				Coordonnee coordonnee = coordonneeRepository.save(ObjectMapperUtility.map(coordonneeRequest, Coordonnee.class));
				return  new CoordonneeResponseSave(ObjectMapperUtility.map(coordonnee, CoordonneeResponse.class));
			}
			catch(Exception e)
			{
				coordonneeResponseError.setHave_error(true);
				return  new CoordonneeResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var coordonnee = coordonneeRepository.findById(id);
			coordonneeRepository.save(coordonnee.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CoordonneeResponseError checkCoordonneeResponseError (CoordonneeRequest coordonneeRequest)
	{
		CoordonneeResponseError coordonneeResponseError = new CoordonneeResponseError();
		coordonneeResponseError.setHave_error(false);
		if(Utility.isEmpty(coordonneeRequest.getId().toString()) )
		{
			coordonneeRequest.setId(-1);
		}
		//if(Utility.isEmpty(coordonneeRequest.get()) )
		//{
				//coordonneeResponseError.setHave_error(true);
				//coordonneeResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return coordonneeResponseError;
	}
}
