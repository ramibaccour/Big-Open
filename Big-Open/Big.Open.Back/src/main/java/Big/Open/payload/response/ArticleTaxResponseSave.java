package big.open.payload.response;
import big.open.payload.response.error.ArticleTaxResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTaxResponseSave
{
	private ArticleTaxResponse articleTaxResponse;
	private ArticleTaxResponseError articleTaxResponseError;
	private String message;
	public ArticleTaxResponseSave(ArticleTaxResponse articleTaxResponse)
	{
		super();
		this.articleTaxResponse = articleTaxResponse;
	}
	public ArticleTaxResponseSave(ArticleTaxResponseError articleTaxResponseError) 
	{
		super();
		this.articleTaxResponseError = articleTaxResponseError;
	}
	public ArticleTaxResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
