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
@Table(name = "reglement")
public class Reglement 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="montant")
	private double montant;
	@Column(name="rib")
	private String rib;
	@Column(name="date_encaissement")
	private LocalDateTime dateEncaissement;
	@Column(name="date_echeance")
	private String dateEcheance;
	@Column(name="debit_credit")
	private String debitCredit;
	@Column(name="observation")
	private String observation;
	@Column(name="rib_compte_source")
	private String ribCompteSource;
	@Column(name="numero_traite")
	private String numeroTraite;
	@Column(name="type_reglement")
	private String typeReglement;
	@Transient
	private Banque banque;
	@Transient
	private Caisse caisse;
	@Transient
	private Document document;
	@Transient
	private RetenuSource retenuSource;
}
