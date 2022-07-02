package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponseList
{
	private List<LngResponse> listLngResponse;
	private Long count;
	private String message;
	public LngResponseList(List<LngResponse> listLngResponse, Long count)
	{
		super();
		this.listLngResponse = listLngResponse;
		this.count = count;
	}
}
