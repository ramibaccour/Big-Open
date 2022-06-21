package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse 
{
	private Integer id;
	private String username;
	private Integer idSociete;
	private Integer isDeleted;
	public UserResponse(Integer id) 
	{
		super();
		this.id = id;
	}
}
