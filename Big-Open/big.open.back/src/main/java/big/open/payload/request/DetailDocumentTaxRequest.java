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
public class DetailDocumentTaxRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String type;
	private String signe;
	private double valeur;
	private boolean calculerAvantTva;
	private TaxRequest tax;
	public DetailDocumentTaxRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
