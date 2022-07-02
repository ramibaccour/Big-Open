package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponseError
{
	private String id;
	private String username;
	private String password;
	private String isDeleted;
	private boolean have_error;
}
