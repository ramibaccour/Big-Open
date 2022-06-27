package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.ArticleTax;
import big.open.payload.request.ArticleTaxRequest;
import big.open.payload.response.ArticleTaxResponse;
import big.open.payload.response.ArticleTaxResponseFindById;
import big.open.payload.response.ArticleTaxResponseSave;
import big.open.payload.response.error.ArticleTaxResponseError;
import big.open.repository.ArticleTaxRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ArticleTaxService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ArticleTaxRepository articleTaxRepository;
	public ArticleTaxResponseFindById findById(Integer id)
	{
		Optional<ArticleTax> articleTax = articleTaxRepository.findById(id);
		if(articleTax.isPresent())
		{
			ArticleTaxResponse articleTaxResponse = ObjectMapperUtility.map(articleTax.get(),ArticleTaxResponse.class);
			return new ArticleTaxResponseFindById(articleTaxResponse);
		}
		return new ArticleTaxResponseFindById("Non trouvé");
	}
	public ArticleTaxResponseSave save(ArticleTaxRequest articleTaxRequest)
	{
		ArticleTaxResponseError articleTaxResponseError = checkArticleTaxResponseError(articleTaxRequest);
		if(articleTaxResponseError.isHave_error())
		{
			return new ArticleTaxResponseSave(articleTaxResponseError);
		}
		else
		{
			try
			{
				ArticleTax articleTax = articleTaxRepository.save(ObjectMapperUtility.map(articleTaxRequest, ArticleTax.class));
				return  new ArticleTaxResponseSave(ObjectMapperUtility.map(articleTax, ArticleTaxResponse.class));
			}
			catch(Exception e)
			{
				articleTaxResponseError.setHave_error(true);
				return  new ArticleTaxResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var articleTax = articleTaxRepository.findById(id);
			articleTaxRepository.save(articleTax.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ArticleTaxResponseError checkArticleTaxResponseError (ArticleTaxRequest articleTaxRequest)
	{
		ArticleTaxResponseError articleTaxResponseError = new ArticleTaxResponseError();
		articleTaxResponseError.setHave_error(false);
		//if(Utility.isEmpty(articleTaxRequest.get()) )
		//{
				//articleTaxResponseError.setHave_error(true);
				//articleTaxResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return articleTaxResponseError;
	}
}
