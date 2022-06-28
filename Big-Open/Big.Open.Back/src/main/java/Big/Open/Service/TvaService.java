package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Tva;
import big.open.payload.request.TvaRequest;
import big.open.payload.response.TvaResponse;
import big.open.payload.response.TvaResponseFindById;
import big.open.payload.response.TvaResponseSave;
import big.open.payload.response.error.TvaResponseError;
import big.open.repository.TvaRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class TvaService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	TvaRepository tvaRepository;
	public TvaResponseFindById findById(Integer id)
	{
		Optional<Tva> tva = tvaRepository.findById(id);
		if(tva.isPresent())
		{
			TvaResponse tvaResponse = ObjectMapperUtility.map(tva.get(),TvaResponse.class);
			return new TvaResponseFindById(tvaResponse);
		}
		return new TvaResponseFindById("Non trouvé");
	}
	public TvaResponseSave save(TvaRequest tvaRequest)
	{
		TvaResponseError tvaResponseError = checkTvaResponseError(tvaRequest);
		if(tvaResponseError.isHave_error())
		{
			return new TvaResponseSave(tvaResponseError);
		}
		else
		{
			try
			{
				Tva tva = tvaRepository.save(ObjectMapperUtility.map(tvaRequest, Tva.class));
				return  new TvaResponseSave(ObjectMapperUtility.map(tva, TvaResponse.class));
			}
			catch(Exception e)
			{
				tvaResponseError.setHave_error(true);
				return  new TvaResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var tva = tvaRepository.findById(id);
			tvaRepository.save(tva.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private TvaResponseError checkTvaResponseError (TvaRequest tvaRequest)
	{
		TvaResponseError tvaResponseError = new TvaResponseError();
		tvaResponseError.setHave_error(false);
		if(Utility.isEmpty(tvaRequest.getId().toString()) )
		{
			tvaRequest.setId(-1);
		}
		//if(Utility.isEmpty(tvaRequest.get()) )
		//{
				//tvaResponseError.setHave_error(true);
				//tvaResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return tvaResponseError;
	}
}
