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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "detail_document")
public class DetailDocument 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nom_article")
	private String nomArticle;
	@Column(name="reference_interne")
	private String referenceInterne;
	@Column(name="nom_unite")
	private String nomUnite;
	@Column(name="quantite_article")
	private double quantiteArticle;
	@Column(name="article_prix")
	private double articlePrix;
	@Column(name="taux_tva")
	private Integer tauxTva;
	@Column(name="total_ht")
	private double totalHt;
	@Transient
	private Article article;
	@Transient
	private Document document;
}
