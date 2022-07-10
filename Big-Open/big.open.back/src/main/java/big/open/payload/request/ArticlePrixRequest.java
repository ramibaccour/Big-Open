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
public class ArticlePrixRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private double prix;
	private boolean ttcHt;
	private ArticleRequest article;
	public ArticlePrixRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
