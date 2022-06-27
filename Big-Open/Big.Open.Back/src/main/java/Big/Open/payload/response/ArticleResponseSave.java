package big.open.payload.response;
import big.open.payload.response.error.ArticleResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponseSave
{
	private ArticleResponse articleResponse;
	private ArticleResponseError articleResponseError;
	private String message;
	public ArticleResponseSave(ArticleResponse articleResponse)
	{
		super();
		this.articleResponse = articleResponse;
	}
	public ArticleResponseSave(ArticleResponseError articleResponseError) 
	{
		super();
		this.articleResponseError = articleResponseError;
	}
	public ArticleResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
