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
public class CategorieRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private CategorieRequest categorie;
	private List<ArticleCategorieRequest> listArticleCategorie;
	private List<CategorieRequest> listCategorie;
	private List<ImageRequest> listImage;
	public CategorieRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
