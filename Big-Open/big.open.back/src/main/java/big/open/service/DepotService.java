package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Depot;
import big.open.payload.request.DepotRequest;
import big.open.payload.response.DepotResponse;
import big.open.payload.response.DepotResponseFindById;
import big.open.payload.response.DepotResponseSave;
import big.open.payload.response.error.DepotResponseError;
import big.open.repository.DepotRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DepotService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DepotRepository depotRepository;
	public DepotResponseFindById findById(Integer id)
	{
		Optional<Depot> depot = depotRepository.findById(id);
		if(depot.isPresent())
		{
			DepotResponse depotResponse = ObjectMapperUtility.map(depot.get(),DepotResponse.class);
			return new DepotResponseFindById(depotResponse);
		}
		return new DepotResponseFindById("Non trouvé");
	}
	public DepotResponseSave save(DepotRequest depotRequest)
	{
		DepotResponseError depotResponseError = checkDepotResponseError(depotRequest);
		if(depotResponseError.isHave_error())
		{
			return new DepotResponseSave(depotResponseError);
		}
		else
		{
			try
			{
				Depot depot = depotRepository.save(ObjectMapperUtility.map(depotRequest, Depot.class));
				return  new DepotResponseSave(ObjectMapperUtility.map(depot, DepotResponse.class));
			}
			catch(Exception e)
			{
				depotResponseError.setHave_error(true);
				return  new DepotResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var depot = depotRepository.findById(id);
			depotRepository.save(depot.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DepotResponseError checkDepotResponseError (DepotRequest depotRequest)
	{
		DepotResponseError depotResponseError = new DepotResponseError();
		depotResponseError.setHave_error(false);
		if(Utility.isEmpty(depotRequest.getId().toString()) )
		{
			depotRequest.setId(-1);
		}
		//if(Utility.isEmpty(depotRequest.get()) )
		//{
				//depotResponseError.setHave_error(true);
				//depotResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return depotResponseError;
	}
}
