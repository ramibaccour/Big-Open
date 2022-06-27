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
public class ImageResponse
{
	private Integer id;
	private String nom;
	private String extentionImage;
	private String resolution;
	private String type;
	private String typeObjet;
	private ArticleResponse articleResponse;
	private CategorieResponse categorieResponse;
	private CollaborateurResponse collaborateurResponse;
	private SocieteResponse societeResponse;
	private List<MonnaieResponse> listMonnaieResponse;
	public ImageResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
