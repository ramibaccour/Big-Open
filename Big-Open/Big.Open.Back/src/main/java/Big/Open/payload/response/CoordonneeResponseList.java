package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CoordonneeResponseList
{
	private List<CoordonneeResponse> listCoordonneeResponse;
	private Long count;
	private String message;
	public CoordonneeResponseList(List<CoordonneeResponse> listCoordonneeResponse, Long count)
	{
		super();
		this.listCoordonneeResponse = listCoordonneeResponse;
		this.count = count;
	}
}
