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
@Table(name = "collaborateur")
public class Collaborateur 
{
	@NotNull()
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="raison_sociale")
	private String raisonSociale;
	@Column(name="matricule_fiscal")
	private String matriculeFiscal;
	@Column(name="delai_paiement")
	private Integer delaiPaiement;
	@Column(name="unite_delai_paiement")
	private String uniteDelaiPaiement;
	@Column(name="type_article_prix")
	private String typeArticlePrix;
	@Column(name="type_collaborateur")
	private String typeCollaborateur;
	@Transient
	private List<Article> listArticle;
	@Transient
	private List<Coordonnee> listCoordonnee;
	@Transient
	private List<Document> listDocument;
	@Transient
	private List<Image> listImage;
}
