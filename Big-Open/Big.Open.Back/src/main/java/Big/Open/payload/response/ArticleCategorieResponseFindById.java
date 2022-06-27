package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleCategorieResponseFindById
{
	private ArticleCategorieResponse articleCategorieResponse;
	private String message;
	public ArticleCategorieResponseFindById(ArticleCategorieResponse articleCategorieResponse)
	{
		super();
		this.articleCategorieResponse = articleCategorieResponse;
	}
	public ArticleCategorieResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
