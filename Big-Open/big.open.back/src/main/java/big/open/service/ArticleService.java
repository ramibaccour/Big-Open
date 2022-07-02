package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Article;
import big.open.payload.request.ArticleRequest;
import big.open.payload.response.ArticleResponse;
import big.open.payload.response.ArticleResponseFindById;
import big.open.payload.response.ArticleResponseSave;
import big.open.payload.response.error.ArticleResponseError;
import big.open.repository.ArticleRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ArticleService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ArticleRepository articleRepository;
	public ArticleResponseFindById findById(Integer id)
	{
		Optional<Article> article = articleRepository.findById(id);
		if(article.isPresent())
		{
			ArticleResponse articleResponse = ObjectMapperUtility.map(article.get(),ArticleResponse.class);
			return new ArticleResponseFindById(articleResponse);
		}
		return new ArticleResponseFindById("");
	}
	public ArticleResponseSave save(ArticleRequest articleRequest)
	{
		ArticleResponseError articleResponseError = checkArticleResponseError(articleRequest);
		if(articleResponseError.isHaveError())
		{
			return new ArticleResponseSave(articleResponseError);
		}
		else
		{
			try
			{
				Article article = articleRepository.save(ObjectMapperUtility.map(articleRequest, Article.class));
				return  new ArticleResponseSave(ObjectMapperUtility.map(article, ArticleResponse.class));
			}
			catch(Exception e)
			{
				articleResponseError.setHaveError(true);
				return  new ArticleResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var article = articleRepository.findById(id);
			if(article.get().getIsDeleted() == 0)
				article.get().setIsDeleted(1);
			else
				article.get().setIsDeleted(0);
			articleRepository.save(article.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ArticleResponseError checkArticleResponseError (ArticleRequest articleRequest)
	{
		ArticleResponseError articleResponseError = new ArticleResponseError();
		articleResponseError.setHaveError(false);
		if(Utility.isEmpty(articleRequest.getId()) )
		{
			articleRequest.setId(-1);
		}
		//if(Utility.isEmpty(articleRequest.get()) )
		//{
				//articleResponseError.setHaveError(true);
				//articleResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return articleResponseError;
	}
}
