package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupeModuleResponseList
{
	private List<GroupeModuleResponse> listGroupeModuleResponse;
	private Long count;
	private String message;
	public GroupeModuleResponseList(List<GroupeModuleResponse> listGroupeModuleResponse, Long count)
	{
		super();
		this.listGroupeModuleResponse = listGroupeModuleResponse;
		this.count = count;
	}
}
