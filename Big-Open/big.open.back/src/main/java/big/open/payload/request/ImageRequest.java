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
public class ImageRequest
{
	private Integer id;
	private String nom;
	private String extentionImage;
	private String resolution;
	private String type;
	private String typeObjet;
	private ArticleRequest article;
	private CategorieRequest categorie;
	private CollaborateurRequest collaborateur;
	private SocieteRequest societe;
	private List<MonnaieRequest> listMonnaie;
	public ImageRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
