package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteResponseList
{
	private List<SocieteResponse> listSocieteResponse;
	private Long count;
	private String message;
	public SocieteResponseList(List<SocieteResponse> listSocieteResponse, Long count)
	{
		super();
		this.listSocieteResponse = listSocieteResponse;
		this.count = count;
	}
}
