package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupeModuleResponseFindById
{
	private GroupeModuleResponse groupeModuleResponse;
	private String message;
	public GroupeModuleResponseFindById(GroupeModuleResponse groupeModuleResponse)
	{
		super();
		this.groupeModuleResponse = groupeModuleResponse;
	}
	public GroupeModuleResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
