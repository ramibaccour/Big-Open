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
public class ArticleCategorieResponse
{
	private Integer id;
	private CategorieResponse categorieResponse;
	private ArticleResponse articleResponse;
	public ArticleCategorieResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
