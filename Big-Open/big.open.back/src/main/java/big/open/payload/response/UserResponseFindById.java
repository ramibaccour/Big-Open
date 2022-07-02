package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseFindById
{
	private UserResponse userResponse;
	private String message;
	public UserResponseFindById(UserResponse userResponse)
	{
		super();
		this.userResponse = userResponse;
	}
	public UserResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
