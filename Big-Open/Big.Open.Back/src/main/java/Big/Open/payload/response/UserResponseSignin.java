package big.open.payload.response;

import big.open.payload.response.erreor.UserResponseError;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class UserResponseSignin 
{
	private UserResponse userResponse;
	private String jwt;
	private UserResponseError userResponseError;
	public UserResponseSignin(UserResponse userResponse, String jwt, String message) 
	{
		super();
		this.userResponse = userResponse;
		this.jwt = jwt;		
	}
	public UserResponseSignin(UserResponseError userResponseError) 
	{
		super();
		this.userResponseError = userResponseError;
	}
	
}