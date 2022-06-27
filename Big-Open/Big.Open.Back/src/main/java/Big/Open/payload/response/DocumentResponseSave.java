package big.open.payload.response;
import big.open.payload.response.error.DocumentResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentResponseSave
{
	private DocumentResponse documentResponse;
	private DocumentResponseError documentResponseError;
	private String message;
	public DocumentResponseSave(DocumentResponse documentResponse)
	{
		super();
		this.documentResponse = documentResponse;
	}
	public DocumentResponseSave(DocumentResponseError documentResponseError) 
	{
		super();
		this.documentResponseError = documentResponseError;
	}
	public DocumentResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
