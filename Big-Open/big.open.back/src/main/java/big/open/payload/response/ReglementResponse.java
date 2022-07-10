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
	private BanqueResponse banque;
	private CaisseResponse caisse;
	private DocumentResponse document;
	private RetenuSourceResponse retenuSource;
	public ReglementResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
