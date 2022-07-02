package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTaxResponse
{
	private Integer id;
	private TaxResponse tax;
	private ArticleResponse article;
	public ArticleTaxResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
