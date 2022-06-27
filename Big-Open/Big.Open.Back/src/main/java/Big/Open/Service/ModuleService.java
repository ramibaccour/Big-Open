package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Module;
import big.open.payload.request.ModuleRequest;
import big.open.payload.response.ModuleResponse;
import big.open.payload.response.ModuleResponseFindById;
import big.open.payload.response.ModuleResponseSave;
import big.open.payload.response.error.ModuleResponseError;
import big.open.repository.ModuleRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class ModuleService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	ModuleRepository moduleRepository;
	public ModuleResponseFindById findById(Integer id)
	{
		Optional<Module> module = moduleRepository.findById(id);
		if(module.isPresent())
		{
			ModuleResponse moduleResponse = ObjectMapperUtility.map(module.get(),ModuleResponse.class);
			return new ModuleResponseFindById(moduleResponse);
		}
		return new ModuleResponseFindById("Non trouvé");
	}
	public ModuleResponseSave save(ModuleRequest moduleRequest)
	{
		ModuleResponseError moduleResponseError = checkModuleResponseError(moduleRequest);
		if(moduleResponseError.isHave_error())
		{
			return new ModuleResponseSave(moduleResponseError);
		}
		else
		{
			try
			{
				Module module = moduleRepository.save(ObjectMapperUtility.map(moduleRequest, Module.class));
				return  new ModuleResponseSave(ObjectMapperUtility.map(module, ModuleResponse.class));
			}
			catch(Exception e)
			{
				moduleResponseError.setHave_error(true);
				return  new ModuleResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var module = moduleRepository.findById(id);
			moduleRepository.save(module.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private ModuleResponseError checkModuleResponseError (ModuleRequest moduleRequest)
	{
		ModuleResponseError moduleResponseError = new ModuleResponseError();
		moduleResponseError.setHave_error(false);
		//if(Utility.isEmpty(moduleRequest.get()) )
		//{
				//moduleResponseError.setHave_error(true);
				//moduleResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return moduleResponseError;
	}
}
