package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotResponseList
{
	private List<DepotResponse> listDepotResponse;
	private Long count;
	private String message;
	public DepotResponseList(List<DepotResponse> listDepotResponse, Long count)
	{
		super();
		this.listDepotResponse = listDepotResponse;
		this.count = count;
	}
}
