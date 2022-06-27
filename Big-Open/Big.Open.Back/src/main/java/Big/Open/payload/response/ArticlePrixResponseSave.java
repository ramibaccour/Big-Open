package big.open.payload.response;
import big.open.payload.response.error.ArticlePrixResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticlePrixResponseSave
{
	private ArticlePrixResponse articlePrixResponse;
	private ArticlePrixResponseError articlePrixResponseError;
	private String message;
	public ArticlePrixResponseSave(ArticlePrixResponse articlePrixResponse)
	{
		super();
		this.articlePrixResponse = articlePrixResponse;
	}
	public ArticlePrixResponseSave(ArticlePrixResponseError articlePrixResponseError) 
	{
		super();
		this.articlePrixResponseError = articlePrixResponseError;
	}
	public ArticlePrixResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
