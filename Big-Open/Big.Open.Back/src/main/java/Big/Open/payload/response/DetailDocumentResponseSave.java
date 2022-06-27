package big.open.payload.response;
import big.open.payload.response.error.DetailDocumentResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentResponseSave
{
	private DetailDocumentResponse detailDocumentResponse;
	private DetailDocumentResponseError detailDocumentResponseError;
	private String message;
	public DetailDocumentResponseSave(DetailDocumentResponse detailDocumentResponse)
	{
		super();
		this.detailDocumentResponse = detailDocumentResponse;
	}
	public DetailDocumentResponseSave(DetailDocumentResponseError detailDocumentResponseError) 
	{
		super();
		this.detailDocumentResponseError = detailDocumentResponseError;
	}
	public DetailDocumentResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
