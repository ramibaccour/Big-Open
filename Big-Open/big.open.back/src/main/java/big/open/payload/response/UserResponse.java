package big.open.payload.response;
import big.open.payload.response.error.UserResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse
{
	private Integer id;
	private String username;
	private String password;
	private Integer isDeleted;
	private String jwt;
	private GroupeModuleResponse groupeModule;
	private UserResponseError responseError;
	private LngResponse lng;
	private PersonneResponse personne;
	public UserResponse(Integer id)
	{
		super();
		this.id = id;
	}
	public UserResponse(UserResponseError responseError)
	{
		super();
		this.responseError = responseError;
	}
}
