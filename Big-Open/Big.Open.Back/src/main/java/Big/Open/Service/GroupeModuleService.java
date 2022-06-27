package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.GroupeModule;
import big.open.payload.request.GroupeModuleRequest;
import big.open.payload.response.GroupeModuleResponse;
import big.open.payload.response.GroupeModuleResponseFindById;
import big.open.payload.response.GroupeModuleResponseSave;
import big.open.payload.response.error.GroupeModuleResponseError;
import big.open.repository.GroupeModuleRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class GroupeModuleService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	GroupeModuleRepository groupeModuleRepository;
	public GroupeModuleResponseFindById findById(Integer id)
	{
		Optional<GroupeModule> groupeModule = groupeModuleRepository.findById(id);
		if(groupeModule.isPresent())
		{
			GroupeModuleResponse groupeModuleResponse = ObjectMapperUtility.map(groupeModule.get(),GroupeModuleResponse.class);
			return new GroupeModuleResponseFindById(groupeModuleResponse);
		}
		return new GroupeModuleResponseFindById("Non trouvé");
	}
	public GroupeModuleResponseSave save(GroupeModuleRequest groupeModuleRequest)
	{
		GroupeModuleResponseError groupeModuleResponseError = checkGroupeModuleResponseError(groupeModuleRequest);
		if(groupeModuleResponseError.isHave_error())
		{
			return new GroupeModuleResponseSave(groupeModuleResponseError);
		}
		else
		{
			try
			{
				GroupeModule groupeModule = groupeModuleRepository.save(ObjectMapperUtility.map(groupeModuleRequest, GroupeModule.class));
				return  new GroupeModuleResponseSave(ObjectMapperUtility.map(groupeModule, GroupeModuleResponse.class));
			}
			catch(Exception e)
			{
				groupeModuleResponseError.setHave_error(true);
				return  new GroupeModuleResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var groupeModule = groupeModuleRepository.findById(id);
			groupeModuleRepository.save(groupeModule.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private GroupeModuleResponseError checkGroupeModuleResponseError (GroupeModuleRequest groupeModuleRequest)
	{
		GroupeModuleResponseError groupeModuleResponseError = new GroupeModuleResponseError();
		groupeModuleResponseError.setHave_error(false);
		//if(Utility.isEmpty(groupeModuleRequest.get()) )
		//{
				//groupeModuleResponseError.setHave_error(true);
				//groupeModuleResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return groupeModuleResponseError;
	}
}
