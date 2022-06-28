package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.ArticlePrix;
import big.open.payload.request.ArticlePrixRequest;
import big.open.payload.response.ArticlePrixResponse;
import big.open.payload.response.ArticlePrixResponseFindById;
import big.open.payload.response.ArticlePrixResponseSave;
import big.open.payload.response.error.ArticlePrixResponseError;
import big.open.repository.ArticlePrixRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ArticlePrixService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ArticlePrixRepository articlePrixRepository;
	public ArticlePrixResponseFindById findById(Integer id)
	{
		Optional<ArticlePrix> articlePrix = articlePrixRepository.findById(id);
		if(articlePrix.isPresent())
		{
			ArticlePrixResponse articlePrixResponse = ObjectMapperUtility.map(articlePrix.get(),ArticlePrixResponse.class);
			return new ArticlePrixResponseFindById(articlePrixResponse);
		}
		return new ArticlePrixResponseFindById("Non trouvé");
	}
	public ArticlePrixResponseSave save(ArticlePrixRequest articlePrixRequest)
	{
		ArticlePrixResponseError articlePrixResponseError = checkArticlePrixResponseError(articlePrixRequest);
		if(articlePrixResponseError.isHave_error())
		{
			return new ArticlePrixResponseSave(articlePrixResponseError);
		}
		else
		{
			try
			{
				ArticlePrix articlePrix = articlePrixRepository.save(ObjectMapperUtility.map(articlePrixRequest, ArticlePrix.class));
				return  new ArticlePrixResponseSave(ObjectMapperUtility.map(articlePrix, ArticlePrixResponse.class));
			}
			catch(Exception e)
			{
				articlePrixResponseError.setHave_error(true);
				return  new ArticlePrixResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var articlePrix = articlePrixRepository.findById(id);
			articlePrixRepository.save(articlePrix.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ArticlePrixResponseError checkArticlePrixResponseError (ArticlePrixRequest articlePrixRequest)
	{
		ArticlePrixResponseError articlePrixResponseError = new ArticlePrixResponseError();
		articlePrixResponseError.setHave_error(false);
		if(Utility.isEmpty(articlePrixRequest.getId().toString()) )
		{
			articlePrixRequest.setId(-1);
		}
		//if(Utility.isEmpty(articlePrixRequest.get()) )
		//{
				//articlePrixResponseError.setHave_error(true);
				//articlePrixResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return articlePrixResponseError;
	}
}
