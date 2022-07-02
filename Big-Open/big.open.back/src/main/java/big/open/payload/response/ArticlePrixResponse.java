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
public class ArticlePrixResponse
{
	private Integer id;
	private double prix;
	private boolean ttcHt;
	private ArticleResponse articleResponse;
	public ArticlePrixResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
