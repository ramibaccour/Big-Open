package big.open.payload.response;
import big.open.payload.response.error.GroupeModuleResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupeModuleResponseSave
{
	private GroupeModuleResponse groupeModuleResponse;
	private GroupeModuleResponseError groupeModuleResponseError;
	private String message;
	public GroupeModuleResponseSave(GroupeModuleResponse groupeModuleResponse)
	{
		super();
		this.groupeModuleResponse = groupeModuleResponse;
	}
	public GroupeModuleResponseSave(GroupeModuleResponseError groupeModuleResponseError) 
	{
		super();
		this.groupeModuleResponseError = groupeModuleResponseError;
	}
	public GroupeModuleResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
