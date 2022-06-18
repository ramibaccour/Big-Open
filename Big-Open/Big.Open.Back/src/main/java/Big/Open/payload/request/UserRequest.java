package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest 
{
	private int id;
	private String username;
	private String password;
	private int IdSociete;
	private Integer isDeleted;
	public UserRequest(Integer id) 
	{
		super();
		this.id = id;
	}
}
