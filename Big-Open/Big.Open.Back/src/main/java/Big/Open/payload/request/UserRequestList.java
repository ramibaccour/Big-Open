package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestList 
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String username;
	private String password;
	private Integer isDeleted;
	private Integer IdSociete;
}
