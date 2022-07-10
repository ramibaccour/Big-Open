package big.open.payload.response;
import big.open.payload.response.error.UserResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
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
