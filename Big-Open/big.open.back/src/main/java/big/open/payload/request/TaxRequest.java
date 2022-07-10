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
public class TaxRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String type;
	private String signe;
	private String valeur;
	private String group;
	private boolean calculerAvantTva;
	private List<ArticleTaxRequest> listArticleTax;
	private List<DetailDocumentTaxRequest> listDetailDocumentTax;
	public TaxRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
