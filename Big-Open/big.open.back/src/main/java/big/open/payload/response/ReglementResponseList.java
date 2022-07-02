package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReglementResponseList
{
	private List<ReglementResponse> listReglementResponse;
	private Long count;
	private String message;
	public ReglementResponseList(List<ReglementResponse> listReglementResponse, Long count)
	{
		super();
		this.listReglementResponse = listReglementResponse;
		this.count = count;
	}
}
