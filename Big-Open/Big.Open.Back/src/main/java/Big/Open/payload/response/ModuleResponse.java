package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private ModuleResponse moduleResponse;
	private List<GroupeModuleResponse> listGroupeModuleResponse;
	private List<ModuleResponse> listModuleResponse;
	public ModuleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
