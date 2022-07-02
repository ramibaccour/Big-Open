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
public class CollaborateurRequest
{
	private Integer id;
	private String raisonSociale;
	private String matriculeFiscal;
	private Integer delaiPaiement;
	private String uniteDelaiPaiement;
	private String typeArticlePrix;
	private String typeCollaborateur;
	private List<ArticleRequest> listArticle;
	private List<CoordonneeRequest> listCoordonnee;
	private List<DocumentRequest> listDocument;
	private List<ImageRequest> listImage;
	public CollaborateurRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
