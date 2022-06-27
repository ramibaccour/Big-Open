package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqueResponseList
{
	private List<MarqueResponse> listMarqueResponse;
	private Long count;
	private String message;
	public MarqueResponseList(List<MarqueResponse> listMarqueResponse, Long count)
	{
		super();
		this.listMarqueResponse = listMarqueResponse;
		this.count = count;
	}
}
