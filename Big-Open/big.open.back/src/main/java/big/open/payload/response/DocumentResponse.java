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
public class DocumentResponse
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
	private CollaborateurResponse collaborateur;
	private List<DetailDocumentResponse> listDetailDocument;
	private List<ReglementResponse> listReglement;
	public DocumentResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
