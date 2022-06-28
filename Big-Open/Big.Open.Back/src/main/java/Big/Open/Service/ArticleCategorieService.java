package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.ArticleCategorie;
import big.open.payload.request.ArticleCategorieRequest;
import big.open.payload.response.ArticleCategorieResponse;
import big.open.payload.response.ArticleCategorieResponseFindById;
import big.open.payload.response.ArticleCategorieResponseSave;
import big.open.payload.response.error.ArticleCategorieResponseError;
import big.open.repository.ArticleCategorieRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ArticleCategorieService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ArticleCategorieRepository articleCategorieRepository;
	public ArticleCategorieResponseFindById findById(Integer id)
	{
		Optional<ArticleCategorie> articleCategorie = articleCategorieRepository.findById(id);
		if(articleCategorie.isPresent())
		{
			ArticleCategorieResponse articleCategorieResponse = ObjectMapperUtility.map(articleCategorie.get(),ArticleCategorieResponse.class);
			return new ArticleCategorieResponseFindById(articleCategorieResponse);
		}
		return new ArticleCategorieResponseFindById("Non trouvé");
	}
	public ArticleCategorieResponseSave save(ArticleCategorieRequest articleCategorieRequest)
	{
		ArticleCategorieResponseError articleCategorieResponseError = checkArticleCategorieResponseError(articleCategorieRequest);
		if(articleCategorieResponseError.isHave_error())
		{
			return new ArticleCategorieResponseSave(articleCategorieResponseError);
		}
		else
		{
			try
			{
				ArticleCategorie articleCategorie = articleCategorieRepository.save(ObjectMapperUtility.map(articleCategorieRequest, ArticleCategorie.class));
				return  new ArticleCategorieResponseSave(ObjectMapperUtility.map(articleCategorie, ArticleCategorieResponse.class));
			}
			catch(Exception e)
			{
				articleCategorieResponseError.setHave_error(true);
				return  new ArticleCategorieResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var articleCategorie = articleCategorieRepository.findById(id);
			articleCategorieRepository.save(articleCategorie.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ArticleCategorieResponseError checkArticleCategorieResponseError (ArticleCategorieRequest articleCategorieRequest)
	{
		ArticleCategorieResponseError articleCategorieResponseError = new ArticleCategorieResponseError();
		articleCategorieResponseError.setHave_error(false);
		if(Utility.isEmpty(articleCategorieRequest.getId().toString()) )
		{
			articleCategorieRequest.setId(-1);
		}
		//if(Utility.isEmpty(articleCategorieRequest.get()) )
		//{
				//articleCategorieResponseError.setHave_error(true);
				//articleCategorieResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return articleCategorieResponseError;
	}
}
