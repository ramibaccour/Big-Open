package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniteResponseList
{
	private List<UniteResponse> listUniteResponse;
	private Long count;
	private String message;
	public UniteResponseList(List<UniteResponse> listUniteResponse, Long count)
	{
		super();
		this.listUniteResponse = listUniteResponse;
		this.count = count;
	}
}
