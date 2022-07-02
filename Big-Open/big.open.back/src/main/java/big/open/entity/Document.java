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
@Table(name = "document")
public class Document 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="numero")
	private String numero;
	@Column(name="date")
	private LocalDateTime date;
	@Column(name="raison_sociale")
	private String raisonSociale;
	@Column(name="matricule_fiscal")
	private String matriculeFiscal;
	@Column(name="type_document")
	private String typeDocument;
	@Column(name="total_ht")
	private double totalHt;
	@Column(name="total_tva")
	private double totalTva;
	@Column(name="total_ttc")
	private double totalTtc;
	@Transient
	private Collaborateur collaborateur;
	@Transient
	private List<DetailDocument> listDetailDocument;
	@Transient
	private List<Reglement> listReglement;
}
