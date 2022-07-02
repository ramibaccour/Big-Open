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
public class DepotArticleResponse
{
	private Integer id;
	private double quantite;
	private double quantiteMin;
	private boolean alertQuantiteMin;
	private DepotResponse depot;
	private ArticleResponse article;
	public DepotArticleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
