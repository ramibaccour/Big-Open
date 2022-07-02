package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponseFindById
{
	private ArticleResponse articleResponse;
	private String message;
	public ArticleResponseFindById(ArticleResponse articleResponse)
	{
		super();
		this.articleResponse = articleResponse;
	}
	public ArticleResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
