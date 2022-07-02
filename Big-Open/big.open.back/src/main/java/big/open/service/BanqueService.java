package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Banque;
import big.open.payload.request.BanqueRequest;
import big.open.payload.response.BanqueResponse;
import big.open.payload.response.BanqueResponseFindById;
import big.open.payload.response.BanqueResponseSave;
import big.open.payload.response.error.BanqueResponseError;
import big.open.repository.BanqueRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class BanqueService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	BanqueRepository banqueRepository;
	public BanqueResponseFindById findById(Integer id)
	{
		Optional<Banque> banque = banqueRepository.findById(id);
		if(banque.isPresent())
		{
			BanqueResponse banqueResponse = ObjectMapperUtility.map(banque.get(),BanqueResponse.class);
			return new BanqueResponseFindById(banqueResponse);
		}
		return new BanqueResponseFindById("");
	}
	public BanqueResponseSave save(BanqueRequest banqueRequest)
	{
		BanqueResponseError banqueResponseError = checkBanqueResponseError(banqueRequest);
		if(banqueResponseError.isHaveError())
		{
			return new BanqueResponseSave(banqueResponseError);
		}
		else
		{
			try
			{
				Banque banque = banqueRepository.save(ObjectMapperUtility.map(banqueRequest, Banque.class));
				return  new BanqueResponseSave(ObjectMapperUtility.map(banque, BanqueResponse.class));
			}
			catch(Exception e)
			{
				banqueResponseError.setHaveError(true);
				return  new BanqueResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var banque = banqueRepository.findById(id);
			banqueRepository.save(banque.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private BanqueResponseError checkBanqueResponseError (BanqueRequest banqueRequest)
	{
		BanqueResponseError banqueResponseError = new BanqueResponseError();
		banqueResponseError.setHaveError(false);
		if(Utility.isEmpty(banqueRequest.getId()) )
		{
			banqueRequest.setId(-1);
		}
		//if(Utility.isEmpty(banqueRequest.get()) )
		//{
				//banqueResponseError.setHaveError(true);
				//banqueResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return banqueResponseError;
	}
}
