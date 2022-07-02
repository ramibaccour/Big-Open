package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.DetailDocumentTax;
import big.open.payload.request.DetailDocumentTaxRequest;
import big.open.payload.response.DetailDocumentTaxResponse;
import big.open.payload.response.DetailDocumentTaxResponseFindById;
import big.open.payload.response.DetailDocumentTaxResponseSave;
import big.open.payload.response.error.DetailDocumentTaxResponseError;
import big.open.repository.DetailDocumentTaxRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DetailDocumentTaxService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DetailDocumentTaxRepository detailDocumentTaxRepository;
	public DetailDocumentTaxResponseFindById findById(Integer id)
	{
		Optional<DetailDocumentTax> detailDocumentTax = detailDocumentTaxRepository.findById(id);
		if(detailDocumentTax.isPresent())
		{
			DetailDocumentTaxResponse detailDocumentTaxResponse = ObjectMapperUtility.map(detailDocumentTax.get(),DetailDocumentTaxResponse.class);
			return new DetailDocumentTaxResponseFindById(detailDocumentTaxResponse);
		}
		return new DetailDocumentTaxResponseFindById("");
	}
	public DetailDocumentTaxResponseSave save(DetailDocumentTaxRequest detailDocumentTaxRequest)
	{
		DetailDocumentTaxResponseError detailDocumentTaxResponseError = checkDetailDocumentTaxResponseError(detailDocumentTaxRequest);
		if(detailDocumentTaxResponseError.isHaveError())
		{
			return new DetailDocumentTaxResponseSave(detailDocumentTaxResponseError);
		}
		else
		{
			try
			{
				DetailDocumentTax detailDocumentTax = detailDocumentTaxRepository.save(ObjectMapperUtility.map(detailDocumentTaxRequest, DetailDocumentTax.class));
				return  new DetailDocumentTaxResponseSave(ObjectMapperUtility.map(detailDocumentTax, DetailDocumentTaxResponse.class));
			}
			catch(Exception e)
			{
				detailDocumentTaxResponseError.setHaveError(true);
				return  new DetailDocumentTaxResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var detailDocumentTax = detailDocumentTaxRepository.findById(id);
			detailDocumentTaxRepository.save(detailDocumentTax.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DetailDocumentTaxResponseError checkDetailDocumentTaxResponseError (DetailDocumentTaxRequest detailDocumentTaxRequest)
	{
		DetailDocumentTaxResponseError detailDocumentTaxResponseError = new DetailDocumentTaxResponseError();
		detailDocumentTaxResponseError.setHaveError(false);
		if(Utility.isEmpty(detailDocumentTaxRequest.getId()) )
		{
			detailDocumentTaxRequest.setId(-1);
		}
		//if(Utility.isEmpty(detailDocumentTaxRequest.get()) )
		//{
				//detailDocumentTaxResponseError.setHaveError(true);
				//detailDocumentTaxResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return detailDocumentTaxResponseError;
	}
}
