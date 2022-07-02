package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.geo.Point;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleTaxRequest
{
	private Integer id;
	private TaxRequest taxRequest;
	private ArticleRequest articleRequest;
	public ArticleTaxRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
