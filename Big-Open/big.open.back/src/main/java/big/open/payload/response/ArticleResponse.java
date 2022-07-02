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
public class ArticleResponse
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
	private CollaborateurResponse collaborateur;
	private TvaResponse tva;
	private UniteResponse unite;
	private List<ArticleCategorieResponse> listArticleCategorie;
	private List<ArticlePrixResponse> listArticlePrix;
	private List<ArticleTaxResponse> listArticleTax;
	private List<DepotArticleResponse> listDepotArticle;
	private List<DetailDocumentResponse> listDetailDocument;
	private List<ImageResponse> listImage;
	public ArticleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
