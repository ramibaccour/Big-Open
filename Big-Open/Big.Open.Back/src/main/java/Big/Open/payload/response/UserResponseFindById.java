package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseFindById 
{
	private UserResponse UserResponse;
	private String message;
	public UserResponseFindById(UserResponse UserResponse) 
	{
		super();
		this.UserResponse = UserResponse;
	}
	public UserResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}