package big.open.payload.response;
import big.open.payload.response.error.ArticleCategorieResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleCategorieResponseSave
{
	private ArticleCategorieResponse articleCategorieResponse;
	private ArticleCategorieResponseError articleCategorieResponseError;
	private String message;
	public ArticleCategorieResponseSave(ArticleCategorieResponse articleCategorieResponse)
	{
		super();
		this.articleCategorieResponse = articleCategorieResponse;
	}
	public ArticleCategorieResponseSave(ArticleCategorieResponseError articleCategorieResponseError) 
	{
		super();
		this.articleCategorieResponseError = articleCategorieResponseError;
	}
	public ArticleCategorieResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
