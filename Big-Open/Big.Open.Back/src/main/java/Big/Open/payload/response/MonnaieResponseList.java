package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonnaieResponseList
{
	private List<MonnaieResponse> listMonnaieResponse;
	private Long count;
	private String message;
	public MonnaieResponseList(List<MonnaieResponse> listMonnaieResponse, Long count)
	{
		super();
		this.listMonnaieResponse = listMonnaieResponse;
		this.count = count;
	}
}
