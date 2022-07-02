package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotArticleResponseList
{
	private List<DepotArticleResponse> listDepotArticleResponse;
	private Long count;
	private String message;
	public DepotArticleResponseList(List<DepotArticleResponse> listDepotArticleResponse, Long count)
	{
		super();
		this.listDepotArticleResponse = listDepotArticleResponse;
		this.count = count;
	}
}
