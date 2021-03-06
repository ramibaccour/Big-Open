package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String username;
	private String password;
	private Integer isDeleted;
	private GroupeModuleRequest groupeModule;
	private LngRequest lng;
	private PersonneRequest personne;
	public UserRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
