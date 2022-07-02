package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotArticleResponseFindById
{
	private DepotArticleResponse depotArticleResponse;
	private String message;
	public DepotArticleResponseFindById(DepotArticleResponse depotArticleResponse)
	{
		super();
		this.depotArticleResponse = depotArticleResponse;
	}
	public DepotArticleResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
