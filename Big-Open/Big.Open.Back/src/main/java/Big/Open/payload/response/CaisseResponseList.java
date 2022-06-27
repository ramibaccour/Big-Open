package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaisseResponseList
{
	private List<CaisseResponse> listCaisseResponse;
	private Long count;
	private String message;
	public CaisseResponseList(List<CaisseResponse> listCaisseResponse, Long count)
	{
		super();
		this.listCaisseResponse = listCaisseResponse;
		this.count = count;
	}
}
