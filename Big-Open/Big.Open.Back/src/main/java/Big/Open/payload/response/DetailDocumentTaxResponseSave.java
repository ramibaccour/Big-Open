package big.open.payload.response;
import big.open.payload.response.error.DetailDocumentTaxResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentTaxResponseSave
{
	private DetailDocumentTaxResponse detailDocumentTaxResponse;
	private DetailDocumentTaxResponseError detailDocumentTaxResponseError;
	private String message;
	public DetailDocumentTaxResponseSave(DetailDocumentTaxResponse detailDocumentTaxResponse)
	{
		super();
		this.detailDocumentTaxResponse = detailDocumentTaxResponse;
	}
	public DetailDocumentTaxResponseSave(DetailDocumentTaxResponseError detailDocumentTaxResponseError) 
	{
		super();
		this.detailDocumentTaxResponseError = detailDocumentTaxResponseError;
	}
	public DetailDocumentTaxResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
