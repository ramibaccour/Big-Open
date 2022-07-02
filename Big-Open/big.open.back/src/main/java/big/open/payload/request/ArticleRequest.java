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
public class ArticleRequest
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String description;
	private String codeBarre;
	private String referenceInterne;
	private String referenceFournisseur;
	private String typeArticle;
	private Integer isDeleted;
	private CollaborateurRequest collaborateur;
	private TvaRequest tva;
	private UniteRequest unite;
	private List<ArticleCategorieRequest> listArticleCategorie;
	private List<ArticlePrixRequest> listArticlePrix;
	private List<ArticleTaxRequest> listArticleTax;
	private List<DepotArticleRequest> listDepotArticle;
	private List<DetailDocumentRequest> listDetailDocument;
	private List<ImageRequest> listImage;
	public ArticleRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
