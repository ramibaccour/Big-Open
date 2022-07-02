package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.DepotArticle;
import big.open.payload.request.DepotArticleRequest;
import big.open.payload.response.DepotArticleResponse;
import big.open.payload.response.DepotArticleResponseFindById;
import big.open.payload.response.DepotArticleResponseSave;
import big.open.payload.response.error.DepotArticleResponseError;
import big.open.repository.DepotArticleRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DepotArticleService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DepotArticleRepository depotArticleRepository;
	public DepotArticleResponseFindById findById(Integer id)
	{
		Optional<DepotArticle> depotArticle = depotArticleRepository.findById(id);
		if(depotArticle.isPresent())
		{
			DepotArticleResponse depotArticleResponse = ObjectMapperUtility.map(depotArticle.get(),DepotArticleResponse.class);
			return new DepotArticleResponseFindById(depotArticleResponse);
		}
		return new DepotArticleResponseFindById("");
	}
	public DepotArticleResponseSave save(DepotArticleRequest depotArticleRequest)
	{
		DepotArticleResponseError depotArticleResponseError = checkDepotArticleResponseError(depotArticleRequest);
		if(depotArticleResponseError.isHaveError())
		{
			return new DepotArticleResponseSave(depotArticleResponseError);
		}
		else
		{
			try
			{
				DepotArticle depotArticle = depotArticleRepository.save(ObjectMapperUtility.map(depotArticleRequest, DepotArticle.class));
				return  new DepotArticleResponseSave(ObjectMapperUtility.map(depotArticle, DepotArticleResponse.class));
			}
			catch(Exception e)
			{
				depotArticleResponseError.setHaveError(true);
				return  new DepotArticleResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var depotArticle = depotArticleRepository.findById(id);
			depotArticleRepository.save(depotArticle.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DepotArticleResponseError checkDepotArticleResponseError (DepotArticleRequest depotArticleRequest)
	{
		DepotArticleResponseError depotArticleResponseError = new DepotArticleResponseError();
		depotArticleResponseError.setHaveError(false);
		if(Utility.isEmpty(depotArticleRequest.getId()) )
		{
			depotArticleRequest.setId(-1);
		}
		//if(Utility.isEmpty(depotArticleRequest.get()) )
		//{
				//depotArticleResponseError.setHaveError(true);
				//depotArticleResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return depotArticleResponseError;
	}
}
