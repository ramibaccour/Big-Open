package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TvaResponseList
{
	private List<TvaResponse> listTvaResponse;
	private Long count;
	private String message;
	public TvaResponseList(List<TvaResponse> listTvaResponse, Long count)
	{
		super();
		this.listTvaResponse = listTvaResponse;
		this.count = count;
	}
}
