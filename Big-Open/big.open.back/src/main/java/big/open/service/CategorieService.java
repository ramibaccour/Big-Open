package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Categorie;
import big.open.payload.request.CategorieRequest;
import big.open.payload.response.CategorieResponse;
import big.open.payload.response.CategorieResponseFindById;
import big.open.payload.response.CategorieResponseSave;
import big.open.payload.response.error.CategorieResponseError;
import big.open.repository.CategorieRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CategorieService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CategorieRepository categorieRepository;
	public CategorieResponseFindById findById(Integer id)
	{
		Optional<Categorie> categorie = categorieRepository.findById(id);
		if(categorie.isPresent())
		{
			CategorieResponse categorieResponse = ObjectMapperUtility.map(categorie.get(),CategorieResponse.class);
			return new CategorieResponseFindById(categorieResponse);
		}
		return new CategorieResponseFindById("");
	}
	public CategorieResponseSave save(CategorieRequest categorieRequest)
	{
		CategorieResponseError categorieResponseError = checkCategorieResponseError(categorieRequest);
		if(categorieResponseError.isHaveError())
		{
			return new CategorieResponseSave(categorieResponseError);
		}
		else
		{
			try
			{
				Categorie categorie = categorieRepository.save(ObjectMapperUtility.map(categorieRequest, Categorie.class));
				return  new CategorieResponseSave(ObjectMapperUtility.map(categorie, CategorieResponse.class));
			}
			catch(Exception e)
			{
				categorieResponseError.setHaveError(true);
				return  new CategorieResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var categorie = categorieRepository.findById(id);
			categorieRepository.save(categorie.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CategorieResponseError checkCategorieResponseError (CategorieRequest categorieRequest)
	{
		CategorieResponseError categorieResponseError = new CategorieResponseError();
		categorieResponseError.setHaveError(false);
		if(Utility.isEmpty(categorieRequest.getId()) )
		{
			categorieRequest.setId(-1);
		}
		//if(Utility.isEmpty(categorieRequest.get()) )
		//{
				//categorieResponseError.setHaveError(true);
				//categorieResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return categorieResponseError;
	}
}
