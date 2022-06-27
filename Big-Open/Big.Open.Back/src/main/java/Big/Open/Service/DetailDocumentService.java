package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.DetailDocument;
import big.open.payload.request.DetailDocumentRequest;
import big.open.payload.response.DetailDocumentResponse;
import big.open.payload.response.DetailDocumentResponseFindById;
import big.open.payload.response.DetailDocumentResponseSave;
import big.open.payload.response.error.DetailDocumentResponseError;
import big.open.repository.DetailDocumentRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DetailDocumentService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DetailDocumentRepository detailDocumentRepository;
	public DetailDocumentResponseFindById findById(Integer id)
	{
		Optional<DetailDocument> detailDocument = detailDocumentRepository.findById(id);
		if(detailDocument.isPresent())
		{
			DetailDocumentResponse detailDocumentResponse = ObjectMapperUtility.map(detailDocument.get(),DetailDocumentResponse.class);
			return new DetailDocumentResponseFindById(detailDocumentResponse);
		}
		return new DetailDocumentResponseFindById("Non trouvé");
	}
	public DetailDocumentResponseSave save(DetailDocumentRequest detailDocumentRequest)
	{
		DetailDocumentResponseError detailDocumentResponseError = checkDetailDocumentResponseError(detailDocumentRequest);
		if(detailDocumentResponseError.isHave_error())
		{
			return new DetailDocumentResponseSave(detailDocumentResponseError);
		}
		else
		{
			try
			{
				DetailDocument detailDocument = detailDocumentRepository.save(ObjectMapperUtility.map(detailDocumentRequest, DetailDocument.class));
				return  new DetailDocumentResponseSave(ObjectMapperUtility.map(detailDocument, DetailDocumentResponse.class));
			}
			catch(Exception e)
			{
				detailDocumentResponseError.setHave_error(true);
				return  new DetailDocumentResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var detailDocument = detailDocumentRepository.findById(id);
			detailDocumentRepository.save(detailDocument.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DetailDocumentResponseError checkDetailDocumentResponseError (DetailDocumentRequest detailDocumentRequest)
	{
		DetailDocumentResponseError detailDocumentResponseError = new DetailDocumentResponseError();
		detailDocumentResponseError.setHave_error(false);
		//if(Utility.isEmpty(detailDocumentRequest.get()) )
		//{
				//detailDocumentResponseError.setHave_error(true);
				//detailDocumentResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return detailDocumentResponseError;
	}
}
