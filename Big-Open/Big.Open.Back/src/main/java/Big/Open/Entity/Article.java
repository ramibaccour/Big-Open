package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import org.springframework.data.geo.Point;
import java.time.LocalDateTime;
import lombok.Data;
import javax.validation.constraints.NotNull;
@Data
@Entity
@Table(name = "article")
public class Article 
{
	@NotNull()
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nom_lng1")
	private String nomLng1;
	@Column(name="nom_lng2")
	private String nomLng2;
	@Column(name="nom_lng3")
	private String nomLng3;
	@Column(name="description")
	private String description;
	@Column(name="code_barre")
	private String codeBarre;
	@Column(name="reference_interne")
	private String referenceInterne;
	@Column(name="reference_fournisseur")
	private String referenceFournisseur;
	@Column(name="type_article")
	private String typeArticle;
	@Column(name="is_deleted")
	private Integer isDeleted;
	@Transient	private Collaborateur collaborateur;
	@Transient	private Tva tva;
	@Transient	private Unite unite;
	@Transient
	private List<ArticleCategorie> listArticleCategorie;
	@Transient
	private List<ArticlePrix> listArticlePrix;
	@Transient
	private List<ArticleTax> listArticleTax;
	@Transient
	private List<DepotArticle> listDepotArticle;
	@Transient
	private List<DetailDocument> listDetailDocument;
	@Transient
	private List<Image> listImage;
}
