package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentTaxResponseList
{
	private List<DetailDocumentTaxResponse> listDetailDocumentTaxResponse;
	private Long count;
	private String message;
	public DetailDocumentTaxResponseList(List<DetailDocumentTaxResponse> listDetailDocumentTaxResponse, Long count)
	{
		super();
		this.listDetailDocumentTaxResponse = listDetailDocumentTaxResponse;
		this.count = count;
	}
}
