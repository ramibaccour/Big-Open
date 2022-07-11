package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.CollaborateurPersonne;
import big.open.payload.request.CollaborateurPersonneRequest;
import big.open.payload.response.CollaborateurPersonneResponse;
import big.open.payload.response.CollaborateurPersonneResponseFindById;
import big.open.payload.response.CollaborateurPersonneResponseSave;
import big.open.payload.response.error.CollaborateurPersonneResponseError;
import big.open.repository.CollaborateurPersonneRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CollaborateurPersonneService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CollaborateurPersonneRepository collaborateurPersonneRepository;
	public CollaborateurPersonneResponseFindById findById(Integer id)
	{
		Optional<CollaborateurPersonne> collaborateurPersonne = collaborateurPersonneRepository.findById(id);
		if(collaborateurPersonne.isPresent())
		{
			CollaborateurPersonneResponse collaborateurPersonneResponse = ObjectMapperUtility.map(collaborateurPersonne.get(),CollaborateurPersonneResponse.class);
			return new CollaborateurPersonneResponseFindById(collaborateurPersonneResponse);
		}
		return new CollaborateurPersonneResponseFindById("");
	}
	public CollaborateurPersonneResponseSave save(CollaborateurPersonneRequest collaborateurPersonneRequest)
	{
		CollaborateurPersonneResponseError collaborateurPersonneResponseError = checkCollaborateurPersonneResponseError(collaborateurPersonneRequest);
		if(collaborateurPersonneResponseError.isHaveError())
		{
			return new CollaborateurPersonneResponseSave(collaborateurPersonneResponseError);
		}
		else
		{
			try
			{
				CollaborateurPersonne collaborateurPersonne = collaborateurPersonneRepository.save(ObjectMapperUtility.map(collaborateurPersonneRequest, CollaborateurPersonne.class));
				return  new CollaborateurPersonneResponseSave(ObjectMapperUtility.map(collaborateurPersonne, CollaborateurPersonneResponse.class));
			}
			catch(Exception e)
			{
				collaborateurPersonneResponseError.setHaveError(true);
				return  new CollaborateurPersonneResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var collaborateurPersonne = collaborateurPersonneRepository.findById(id);
			collaborateurPersonneRepository.save(collaborateurPersonne.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CollaborateurPersonneResponseError checkCollaborateurPersonneResponseError (CollaborateurPersonneRequest collaborateurPersonneRequest)
	{
		CollaborateurPersonneResponseError collaborateurPersonneResponseError = new CollaborateurPersonneResponseError();
		collaborateurPersonneResponseError.setHaveError(false);
		if(Utility.isEmpty(collaborateurPersonneRequest.getId()) )
		{
			collaborateurPersonneRequest.setId(-1);
		}
		//if(Utility.isEmpty(collaborateurPersonneRequest.get()) )
		//{
				//collaborateurPersonneResponseError.setHaveError(true);
				//collaborateurPersonneResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return collaborateurPersonneResponseError;
	}
}
