package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Document;
import big.open.payload.request.DocumentRequest;
import big.open.payload.response.DocumentResponse;
import big.open.payload.response.DocumentResponseFindById;
import big.open.payload.response.DocumentResponseSave;
import big.open.payload.response.error.DocumentResponseError;
import big.open.repository.DocumentRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DocumentService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DocumentRepository documentRepository;
	public DocumentResponseFindById findById(Integer id)
	{
		Optional<Document> document = documentRepository.findById(id);
		if(document.isPresent())
		{
			DocumentResponse documentResponse = ObjectMapperUtility.map(document.get(),DocumentResponse.class);
			return new DocumentResponseFindById(documentResponse);
		}
		return new DocumentResponseFindById("");
	}
	public DocumentResponseSave save(DocumentRequest documentRequest)
	{
		DocumentResponseError documentResponseError = checkDocumentResponseError(documentRequest);
		if(documentResponseError.isHaveError())
		{
			return new DocumentResponseSave(documentResponseError);
		}
		else
		{
			try
			{
				Document document = documentRepository.save(ObjectMapperUtility.map(documentRequest, Document.class));
				return  new DocumentResponseSave(ObjectMapperUtility.map(document, DocumentResponse.class));
			}
			catch(Exception e)
			{
				documentResponseError.setHaveError(true);
				return  new DocumentResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var document = documentRepository.findById(id);
			documentRepository.save(document.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DocumentResponseError checkDocumentResponseError (DocumentRequest documentRequest)
	{
		DocumentResponseError documentResponseError = new DocumentResponseError();
		documentResponseError.setHaveError(false);
		if(Utility.isEmpty(documentRequest.getId()) )
		{
			documentRequest.setId(-1);
		}
		//if(Utility.isEmpty(documentRequest.get()) )
		//{
				//documentResponseError.setHaveError(true);
				//documentResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return documentResponseError;
	}
}
