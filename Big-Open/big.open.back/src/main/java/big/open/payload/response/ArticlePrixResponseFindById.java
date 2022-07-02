package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticlePrixResponseFindById
{
	private ArticlePrixResponse articlePrixResponse;
	private String message;
	public ArticlePrixResponseFindById(ArticlePrixResponse articlePrixResponse)
	{
		super();
		this.articlePrixResponse = articlePrixResponse;
	}
	public ArticlePrixResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
