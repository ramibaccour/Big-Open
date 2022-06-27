package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleResponseList
{
	private List<ArticleResponse> listArticleResponse;
	private Long count;
	private String message;
	public ArticleResponseList(List<ArticleResponse> listArticleResponse, Long count)
	{
		super();
		this.listArticleResponse = listArticleResponse;
		this.count = count;
	}
}
