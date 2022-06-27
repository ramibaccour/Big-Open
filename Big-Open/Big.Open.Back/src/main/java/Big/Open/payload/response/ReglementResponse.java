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
public class ReglementResponse
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
	private BanqueResponse banqueResponse;
	private CaisseResponse caisseResponse;
	private DocumentResponse documentResponse;
	private DocumentResponse documentAvoirResponse;
	private RetenuSourceResponse retenuSourceResponse;
	public ReglementResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
