package big.open.payload.response;
import big.open.payload.response.error.DepotArticleResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepotArticleResponseSave
{
	private DepotArticleResponse depotArticleResponse;
	private DepotArticleResponseError depotArticleResponseError;
	private String message;
	public DepotArticleResponseSave(DepotArticleResponse depotArticleResponse)
	{
		super();
		this.depotArticleResponse = depotArticleResponse;
	}
	public DepotArticleResponseSave(DepotArticleResponseError depotArticleResponseError) 
	{
		super();
		this.depotArticleResponseError = depotArticleResponseError;
	}
	public DepotArticleResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
