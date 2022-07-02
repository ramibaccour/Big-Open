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
	private List<ArticleRequest> listArticleRequest;
	private List<CoordonneeRequest> listCoordonneeRequest;
	private List<DocumentRequest> listDocumentRequest;
	private List<ImageRequest> listImageRequest;
	public CollaborateurRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
