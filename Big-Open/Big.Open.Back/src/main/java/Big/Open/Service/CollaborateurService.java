package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Collaborateur;
import big.open.payload.request.CollaborateurRequest;
import big.open.payload.response.CollaborateurResponse;
import big.open.payload.response.CollaborateurResponseFindById;
import big.open.payload.response.CollaborateurResponseSave;
import big.open.payload.response.error.CollaborateurResponseError;
import big.open.repository.CollaborateurRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class CollaborateurService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	CollaborateurRepository collaborateurRepository;
	public CollaborateurResponseFindById findById(Integer id)
	{
		Optional<Collaborateur> collaborateur = collaborateurRepository.findById(id);
		if(collaborateur.isPresent())
		{
			CollaborateurResponse collaborateurResponse = ObjectMapperUtility.map(collaborateur.get(),CollaborateurResponse.class);
			return new CollaborateurResponseFindById(collaborateurResponse);
		}
		return new CollaborateurResponseFindById("Non trouvé");
	}
	public CollaborateurResponseSave save(CollaborateurRequest collaborateurRequest)
	{
		CollaborateurResponseError collaborateurResponseError = checkCollaborateurResponseError(collaborateurRequest);
		if(collaborateurResponseError.isHave_error())
		{
			return new CollaborateurResponseSave(collaborateurResponseError);
		}
		else
		{
			try
			{
				Collaborateur collaborateur = collaborateurRepository.save(ObjectMapperUtility.map(collaborateurRequest, Collaborateur.class));
				return  new CollaborateurResponseSave(ObjectMapperUtility.map(collaborateur, CollaborateurResponse.class));
			}
			catch(Exception e)
			{
				collaborateurResponseError.setHave_error(true);
				return  new CollaborateurResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var collaborateur = collaborateurRepository.findById(id);
			collaborateurRepository.save(collaborateur.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private CollaborateurResponseError checkCollaborateurResponseError (CollaborateurRequest collaborateurRequest)
	{
		CollaborateurResponseError collaborateurResponseError = new CollaborateurResponseError();
		collaborateurResponseError.setHave_error(false);
		//if(Utility.isEmpty(collaborateurRequest.get()) )
		//{
				//collaborateurResponseError.setHave_error(true);
				//collaborateurResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return collaborateurResponseError;
	}
}
