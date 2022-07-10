package big.open.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Lng;
import big.open.payload.request.LngRequest;
import big.open.payload.response.LngResponse;
import big.open.payload.response.LngResponseFindById;
import big.open.payload.response.LngResponseList;
import big.open.payload.response.LngResponseSave;
import big.open.payload.response.error.LngResponseError;
import big.open.repository.LngRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class LngService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	LngRepository lngRepository;
	public LngResponseFindById findById(Integer id)
	{
		Optional<Lng> lng = lngRepository.findById(id);
		if(lng.isPresent())
		{
			LngResponse lngResponse = ObjectMapperUtility.map(lng.get(),LngResponse.class);
			return new LngResponseFindById(lngResponse);
		}
		return new LngResponseFindById("");
	}
	public LngResponseSave save(LngRequest lngRequest)
	{
		LngResponseError lngResponseError = checkLngResponseError(lngRequest);
		if(lngResponseError.isHaveError())
		{
			return new LngResponseSave(lngResponseError);
		}
		else
		{
			try
			{
				Lng lng = lngRepository.save(ObjectMapperUtility.map(lngRequest, Lng.class));
				return  new LngResponseSave(ObjectMapperUtility.map(lng, LngResponse.class));
			}
			catch(Exception e)
			{
				lngResponseError.setHaveError(true);
				return  new LngResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public LngResponseList findAll()
	{
		var listLng = lngRepository.findAll();
		LngResponseList lngResponseList = new LngResponseList(ObjectMapperUtility.mapAll(listLng, LngResponse.class), Long.valueOf(listLng.size()));
		return lngResponseList;
	}
	public String delete(Integer id)
	{
		try
		{
			var lng = lngRepository.findById(id);
			lngRepository.save(lng.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private LngResponseError checkLngResponseError (LngRequest lngRequest)
	{
		LngResponseError lngResponseError = new LngResponseError();
		lngResponseError.setHaveError(false);
		if(Utility.isEmpty(lngRequest.getId()) )
		{
			lngRequest.setId(-1);
		}
		//if(Utility.isEmpty(lngRequest.get()) )
		//{
				//lngResponseError.setHaveError(true);
				//lngResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return lngResponseError;
	}
}