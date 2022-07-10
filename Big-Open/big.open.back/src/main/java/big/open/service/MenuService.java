package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.Menu;
import big.open.payload.request.MenuRequest;
import big.open.payload.response.MenuResponse;
import big.open.payload.response.MenuResponseFindById;
import big.open.payload.response.MenuResponseSave;
import big.open.payload.response.error.MenuResponseError;
import big.open.repository.MenuRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class MenuService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	MenuRepository menuRepository;
	public MenuResponseFindById findById(Integer id)
	{
		Optional<Menu> menu = menuRepository.findById(id);
		if(menu.isPresent())
		{
			MenuResponse menuResponse = ObjectMapperUtility.map(menu.get(),MenuResponse.class);
			return new MenuResponseFindById(menuResponse);
		}
		return new MenuResponseFindById("");
	}
	public MenuResponseSave save(MenuRequest menuRequest)
	{
		MenuResponseError menuResponseError = checkMenuResponseError(menuRequest);
		if(menuResponseError.isHaveError())
		{
			return new MenuResponseSave(menuResponseError);
		}
		else
		{
			try
			{
				Menu menu = menuRepository.save(ObjectMapperUtility.map(menuRequest, Menu.class));
				return  new MenuResponseSave(ObjectMapperUtility.map(menu, MenuResponse.class));
			}
			catch(Exception e)
			{
				menuResponseError.setHaveError(true);
				return  new MenuResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var menu = menuRepository.findById(id);
			menuRepository.save(menu.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private MenuResponseError checkMenuResponseError (MenuRequest menuRequest)
	{
		MenuResponseError menuResponseError = new MenuResponseError();
		menuResponseError.setHaveError(false);
		if(Utility.isEmpty(menuRequest.getId()) )
		{
			menuRequest.setId(-1);
		}
		//if(Utility.isEmpty(menuRequest.get()) )
		//{
				//menuResponseError.setHaveError(true);
				//menuResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return menuResponseError;
	}
}
