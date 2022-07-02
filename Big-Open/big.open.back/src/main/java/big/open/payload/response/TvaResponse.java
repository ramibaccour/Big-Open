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
public class TvaResponse
{
	private Integer id;
	private Integer taux;
	private List<ArticleResponse> listArticle;
	public TvaResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
