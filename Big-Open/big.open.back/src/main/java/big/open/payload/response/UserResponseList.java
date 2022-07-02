package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseList
{
	private List<UserResponse> listUserResponse;
	private Long count;
	private String message;
	public UserResponseList(List<UserResponse> listUserResponse, Long count)
	{
		super();
		this.listUserResponse = listUserResponse;
		this.count = count;
	}
}
