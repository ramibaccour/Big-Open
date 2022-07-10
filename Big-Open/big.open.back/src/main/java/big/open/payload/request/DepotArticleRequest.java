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
public class DepotArticleRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private double quantite;
	private double quantiteMin;
	private boolean alertQuantiteMin;
	private DepotRequest depot;
	private ArticleRequest article;
	public DepotArticleRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
