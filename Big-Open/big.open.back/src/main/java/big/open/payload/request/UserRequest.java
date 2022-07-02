package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;

import big.open.payload.response.LngResponse;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest
{
	private Integer id;
	private String username;
	private String password;
	private Integer isDeleted;
	private LngResponse lng;
	private GroupeModuleRequest groupeModule;
	public UserRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
