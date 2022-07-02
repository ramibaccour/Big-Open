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
public class DocumentRequest
{
	private Integer id;
	private String numero;
	private LocalDateTime date;
	private String raisonSociale;
	private String matriculeFiscal;
	private String typeDocument;
	private double totalHt;
	private double totalTva;
	private double totalTtc;
	private CollaborateurRequest collaborateur;
	private List<DetailDocumentRequest> listDetailDocument;
	private List<ReglementRequest> listReglement;
	public DocumentRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
