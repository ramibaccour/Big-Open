package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentTaxResponseFindById
{
	private DetailDocumentTaxResponse detailDocumentTaxResponse;
	private String message;
	public DetailDocumentTaxResponseFindById(DetailDocumentTaxResponse detailDocumentTaxResponse)
	{
		super();
		this.detailDocumentTaxResponse = detailDocumentTaxResponse;
	}
	public DetailDocumentTaxResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
