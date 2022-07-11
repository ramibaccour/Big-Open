package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Personne;
import big.open.payload.request.PersonneRequest;
import big.open.payload.response.PersonneResponse;
import big.open.payload.response.PersonneResponseFindById;
import big.open.payload.response.PersonneResponseSave;
import big.open.payload.response.error.PersonneResponseError;
import big.open.repository.PersonneRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class PersonneService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	PersonneRepository personneRepository;
	public PersonneResponseFindById findById(Integer id)
	{
		Optional<Personne> personne = personneRepository.findById(id);
		if(personne.isPresent())
		{
			PersonneResponse personneResponse = ObjectMapperUtility.map(personne.get(),PersonneResponse.class);
			return new PersonneResponseFindById(personneResponse);
		}
		return new PersonneResponseFindById("");
	}
	public PersonneResponseSave save(PersonneRequest personneRequest)
	{
		PersonneResponseError personneResponseError = checkPersonneResponseError(personneRequest);
		if(personneResponseError.isHaveError())
		{
			return new PersonneResponseSave(personneResponseError);
		}
		else
		{
			try
			{
				Personne personne = personneRepository.save(ObjectMapperUtility.map(personneRequest, Personne.class));
				return  new PersonneResponseSave(ObjectMapperUtility.map(personne, PersonneResponse.class));
			}
			catch(Exception e)
			{
				personneResponseError.setHaveError(true);
				return  new PersonneResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var personne = personneRepository.findById(id);
			personneRepository.save(personne.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private PersonneResponseError checkPersonneResponseError (PersonneRequest personneRequest)
	{
		PersonneResponseError personneResponseError = new PersonneResponseError();
		personneResponseError.setHaveError(false);
		if(Utility.isEmpty(personneRequest.getId()) )
		{
			personneRequest.setId(-1);
		}
		//if(Utility.isEmpty(personneRequest.get()) )
		//{
				//personneResponseError.setHaveError(true);
				//personneResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return personneResponseError;
	}
}
