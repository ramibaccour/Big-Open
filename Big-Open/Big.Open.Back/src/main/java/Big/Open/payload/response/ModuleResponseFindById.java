package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleResponseFindById
{
	private ModuleResponse moduleResponse;
	private String message;
	public ModuleResponseFindById(ModuleResponse moduleResponse)
	{
		super();
		this.moduleResponse = moduleResponse;
	}
	public ModuleResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
