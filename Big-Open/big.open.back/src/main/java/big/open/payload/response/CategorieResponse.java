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
public class CategorieResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private CategorieResponse categorie;
	private List<ArticleCategorieResponse> listArticleCategorie;
	private List<CategorieResponse> listCategorie;
	private List<ImageResponse> listImage;
	public CategorieResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
