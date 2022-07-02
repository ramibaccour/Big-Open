package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleResponseList
{
	private List<ModuleResponse> listModuleResponse;
	private Long count;
	private String message;
	public ModuleResponseList(List<ModuleResponse> listModuleResponse, Long count)
	{
		super();
		this.listModuleResponse = listModuleResponse;
		this.count = count;
	}
}
