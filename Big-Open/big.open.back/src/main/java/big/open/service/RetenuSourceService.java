package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.RetenuSource;
import big.open.payload.request.RetenuSourceRequest;
import big.open.payload.response.RetenuSourceResponse;
import big.open.payload.response.RetenuSourceResponseFindById;
import big.open.payload.response.RetenuSourceResponseSave;
import big.open.payload.response.error.RetenuSourceResponseError;
import big.open.repository.RetenuSourceRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class RetenuSourceService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RetenuSourceRepository retenuSourceRepository;
	public RetenuSourceResponseFindById findById(Integer id)
	{
		Optional<RetenuSource> retenuSource = retenuSourceRepository.findById(id);
		if(retenuSource.isPresent())
		{
			RetenuSourceResponse retenuSourceResponse = ObjectMapperUtility.map(retenuSource.get(),RetenuSourceResponse.class);
			return new RetenuSourceResponseFindById(retenuSourceResponse);
		}
		return new RetenuSourceResponseFindById("");
	}
	public RetenuSourceResponseSave save(RetenuSourceRequest retenuSourceRequest)
	{
		RetenuSourceResponseError retenuSourceResponseError = checkRetenuSourceResponseError(retenuSourceRequest);
		if(retenuSourceResponseError.isHaveError())
		{
			return new RetenuSourceResponseSave(retenuSourceResponseError);
		}
		else
		{
			try
			{
				RetenuSource retenuSource = retenuSourceRepository.save(ObjectMapperUtility.map(retenuSourceRequest, RetenuSource.class));
				return  new RetenuSourceResponseSave(ObjectMapperUtility.map(retenuSource, RetenuSourceResponse.class));
			}
			catch(Exception e)
			{
				retenuSourceResponseError.setHaveError(true);
				return  new RetenuSourceResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var retenuSource = retenuSourceRepository.findById(id);
			retenuSourceRepository.save(retenuSource.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private RetenuSourceResponseError checkRetenuSourceResponseError (RetenuSourceRequest retenuSourceRequest)
	{
		RetenuSourceResponseError retenuSourceResponseError = new RetenuSourceResponseError();
		retenuSourceResponseError.setHaveError(false);
		if(Utility.isEmpty(retenuSourceRequest.getId()) )
		{
			retenuSourceRequest.setId(-1);
		}
		//if(Utility.isEmpty(retenuSourceRequest.get()) )
		//{
				//retenuSourceResponseError.setHaveError(true);
				//retenuSourceResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return retenuSourceResponseError;
	}
}
