package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
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
	private GroupeModuleResponse groupeModuleResponse;
	public UserResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
