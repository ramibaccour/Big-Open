package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticlePrixResponseList
{
	private List<ArticlePrixResponse> listArticlePrixResponse;
	private Long count;
	private String message;
	public ArticlePrixResponseList(List<ArticlePrixResponse> listArticlePrixResponse, Long count)
	{
		super();
		this.listArticlePrixResponse = listArticlePrixResponse;
		this.count = count;
	}
}
