package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
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
