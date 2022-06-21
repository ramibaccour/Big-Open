package big.open.payload.response.erreor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseError
{
	private String id;
	private String username;
	private String password;
	private String idSociete;
	private String isDeleted;
	private String usernamePassword ;
	private boolean have_error;
	public UserResponseError(String usernamePassword)
	{
		super();
		this.usernamePassword = usernamePassword;
	}
}
