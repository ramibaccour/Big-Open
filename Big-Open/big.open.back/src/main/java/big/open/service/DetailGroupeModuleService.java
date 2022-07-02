package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.DetailGroupeModule;
import big.open.payload.request.DetailGroupeModuleRequest;
import big.open.payload.response.DetailGroupeModuleResponse;
import big.open.payload.response.DetailGroupeModuleResponseFindById;
import big.open.payload.response.DetailGroupeModuleResponseSave;
import big.open.payload.response.error.DetailGroupeModuleResponseError;
import big.open.repository.DetailGroupeModuleRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class DetailGroupeModuleService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	DetailGroupeModuleRepository detailGroupeModuleRepository;
	public DetailGroupeModuleResponseFindById findById(Integer id)
	{
		Optional<DetailGroupeModule> detailGroupeModule = detailGroupeModuleRepository.findById(id);
		if(detailGroupeModule.isPresent())
		{
			DetailGroupeModuleResponse detailGroupeModuleResponse = ObjectMapperUtility.map(detailGroupeModule.get(),DetailGroupeModuleResponse.class);
			return new DetailGroupeModuleResponseFindById(detailGroupeModuleResponse);
		}
		return new DetailGroupeModuleResponseFindById("");
	}
	public DetailGroupeModuleResponseSave save(DetailGroupeModuleRequest detailGroupeModuleRequest)
	{
		DetailGroupeModuleResponseError detailGroupeModuleResponseError = checkDetailGroupeModuleResponseError(detailGroupeModuleRequest);
		if(detailGroupeModuleResponseError.isHaveError())
		{
			return new DetailGroupeModuleResponseSave(detailGroupeModuleResponseError);
		}
		else
		{
			try
			{
				DetailGroupeModule detailGroupeModule = detailGroupeModuleRepository.save(ObjectMapperUtility.map(detailGroupeModuleRequest, DetailGroupeModule.class));
				return  new DetailGroupeModuleResponseSave(ObjectMapperUtility.map(detailGroupeModule, DetailGroupeModuleResponse.class));
			}
			catch(Exception e)
			{
				detailGroupeModuleResponseError.setHaveError(true);
				return  new DetailGroupeModuleResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var detailGroupeModule = detailGroupeModuleRepository.findById(id);
			detailGroupeModuleRepository.save(detailGroupeModule.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private DetailGroupeModuleResponseError checkDetailGroupeModuleResponseError (DetailGroupeModuleRequest detailGroupeModuleRequest)
	{
		DetailGroupeModuleResponseError detailGroupeModuleResponseError = new DetailGroupeModuleResponseError();
		detailGroupeModuleResponseError.setHaveError(false);
		if(Utility.isEmpty(detailGroupeModuleRequest.getId()) )
		{
			detailGroupeModuleRequest.setId(-1);
		}
		//if(Utility.isEmpty(detailGroupeModuleRequest.get()) )
		//{
				//detailGroupeModuleResponseError.setHaveError(true);
				//detailGroupeModuleResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return detailGroupeModuleResponseError;
	}
}
