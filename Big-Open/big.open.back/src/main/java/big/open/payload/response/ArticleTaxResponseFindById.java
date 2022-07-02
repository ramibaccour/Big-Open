package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTaxResponseFindById
{
	private ArticleTaxResponse articleTaxResponse;
	private String message;
	public ArticleTaxResponseFindById(ArticleTaxResponse articleTaxResponse)
	{
		super();
		this.articleTaxResponse = articleTaxResponse;
	}
	public ArticleTaxResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
