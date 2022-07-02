package big.open.payload.response;
import big.open.payload.response.error.ModuleResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleResponseSave
{
	private ModuleResponse moduleResponse;
	private ModuleResponseError moduleResponseError;
	private String message;
	public ModuleResponseSave(ModuleResponse moduleResponse)
	{
		super();
		this.moduleResponse = moduleResponse;
	}
	public ModuleResponseSave(ModuleResponseError moduleResponseError) 
	{
		super();
		this.moduleResponseError = moduleResponseError;
	}
	public ModuleResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
