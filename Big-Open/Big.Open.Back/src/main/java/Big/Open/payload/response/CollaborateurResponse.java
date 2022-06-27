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
public class CollaborateurResponse
{
	private Integer id;
	private String raisonSociale;
	private String matriculeFiscal;
	private Integer delaiPaiement;
	private String uniteDelaiPaiement;
	private String typeArticlePrix;
	private String typeCollaborateur;
	private List<ArticleResponse> listArticleResponse;
	private List<CoordonneeResponse> listCoordonneeResponse;
	private List<DocumentResponse> listDocumentResponse;
	private List<ImageResponse> listImageResponse;
	public CollaborateurResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
