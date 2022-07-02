package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetenuSourceResponseList
{
	private List<RetenuSourceResponse> listRetenuSourceResponse;
	private Long count;
	private String message;
	public RetenuSourceResponseList(List<RetenuSourceResponse> listRetenuSourceResponse, Long count)
	{
		super();
		this.listRetenuSourceResponse = listRetenuSourceResponse;
		this.count = count;
	}
}
