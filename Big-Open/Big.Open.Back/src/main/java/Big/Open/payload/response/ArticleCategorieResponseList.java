package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleCategorieResponseList
{
	private List<ArticleCategorieResponse> listArticleCategorieResponse;
	private Long count;
	private String message;
	public ArticleCategorieResponseList(List<ArticleCategorieResponse> listArticleCategorieResponse, Long count)
	{
		super();
		this.listArticleCategorieResponse = listArticleCategorieResponse;
		this.count = count;
	}
}
