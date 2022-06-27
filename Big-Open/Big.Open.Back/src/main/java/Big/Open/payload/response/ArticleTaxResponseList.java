package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTaxResponseList
{
	private List<ArticleTaxResponse> listArticleTaxResponse;
	private Long count;
	private String message;
	public ArticleTaxResponseList(List<ArticleTaxResponse> listArticleTaxResponse, Long count)
	{
		super();
		this.listArticleTaxResponse = listArticleTaxResponse;
		this.count = count;
	}
}
