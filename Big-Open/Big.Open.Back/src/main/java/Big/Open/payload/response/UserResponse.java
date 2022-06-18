package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse 
{
	private int id;
	private String username;
	private String password;
	private int IdSociete;
	public UserResponse(Integer id) 
	{
		super();
		this.id = id;
	}
}
