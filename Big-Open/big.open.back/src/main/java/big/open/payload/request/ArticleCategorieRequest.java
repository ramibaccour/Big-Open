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
public class ArticleCategorieRequest
{
	private Integer id;
	private CategorieRequest categorieRequest;
	private ArticleRequest articleRequest;
	public ArticleCategorieRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
