package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest 
{
	private Integer id;
	private String username;
	private String password;
	private Integer idSociete;
	private Integer isDeleted;
	public UserRequest(Integer id) 
	{
		super();
		this.id = id;
	}
}
