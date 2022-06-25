package big.open.payload.response;
import big.open.payload.response.erreor.UserResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseSave 
{
	private UserResponse userResponse;
	private UserResponseError userResponseError;
	private String message;
	public UserResponseSave(UserResponse userResponse) 
	{
		super();
		this.userResponse = userResponse;	
	}
	public UserResponseSave(UserResponseError userResponseError) 
	{
		super();
		this.userResponseError = userResponseError;
	}
	public UserResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
