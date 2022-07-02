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
public class ReglementRequest
{
	private Integer id;
	private double montant;
	private String rib;
	private LocalDateTime dateEncaissement;
	private String dateEcheance;
	private String debitCredit;
	private String observation;
	private String ribCompteSource;
	private String numeroTraite;
	private String typeReglement;
	private BanqueRequest banque;
	private CaisseRequest caisse;
	private DocumentRequest document;
	private RetenuSourceRequest retenuSource;
	public ReglementRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
