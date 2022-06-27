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
public class TaxResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String type;
	private String signe;
	private String valeur;
	private String group;
	private boolean calculerAvantTva;
	private List<ArticleTaxResponse> listArticleTaxResponse;
	private List<DetailDocumentTaxResponse> listDetailDocumentTaxResponse;
	public TaxResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
