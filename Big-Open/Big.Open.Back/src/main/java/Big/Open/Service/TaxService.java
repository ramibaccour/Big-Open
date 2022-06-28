package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Tax;
import big.open.payload.request.TaxRequest;
import big.open.payload.response.TaxResponse;
import big.open.payload.response.TaxResponseFindById;
import big.open.payload.response.TaxResponseSave;
import big.open.payload.response.error.TaxResponseError;
import big.open.repository.TaxRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class TaxService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	TaxRepository taxRepository;
	public TaxResponseFindById findById(Integer id)
	{
		Optional<Tax> tax = taxRepository.findById(id);
		if(tax.isPresent())
		{
			TaxResponse taxResponse = ObjectMapperUtility.map(tax.get(),TaxResponse.class);
			return new TaxResponseFindById(taxResponse);
		}
		return new TaxResponseFindById("Non trouvé");
	}
	public TaxResponseSave save(TaxRequest taxRequest)
	{
		TaxResponseError taxResponseError = checkTaxResponseError(taxRequest);
		if(taxResponseError.isHave_error())
		{
			return new TaxResponseSave(taxResponseError);
		}
		else
		{
			try
			{
				Tax tax = taxRepository.save(ObjectMapperUtility.map(taxRequest, Tax.class));
				return  new TaxResponseSave(ObjectMapperUtility.map(tax, TaxResponse.class));
			}
			catch(Exception e)
			{
				taxResponseError.setHave_error(true);
				return  new TaxResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var tax = taxRepository.findById(id);
			taxRepository.save(tax.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private TaxResponseError checkTaxResponseError (TaxRequest taxRequest)
	{
		TaxResponseError taxResponseError = new TaxResponseError();
		taxResponseError.setHave_error(false);
		if(Utility.isEmpty(taxRequest.getId().toString()) )
		{
			taxRequest.setId(-1);
		}
		//if(Utility.isEmpty(taxRequest.get()) )
		//{
				//taxResponseError.setHave_error(true);
				//taxResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return taxResponseError;
	}
}
