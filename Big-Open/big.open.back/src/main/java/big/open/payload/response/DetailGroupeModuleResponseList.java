package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailGroupeModuleResponseList
{
	private List<DetailGroupeModuleResponse> listDetailGroupeModuleResponse;
	private Long count;
	private String message;
	public DetailGroupeModuleResponseList(List<DetailGroupeModuleResponse> listDetailGroupeModuleResponse, Long count)
	{
		super();
		this.listDetailGroupeModuleResponse = listDetailGroupeModuleResponse;
		this.count = count;
	}
}
