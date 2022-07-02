package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentResponseFindById
{
	private DocumentResponse documentResponse;
	private String message;
	public DocumentResponseFindById(DocumentResponse documentResponse)
	{
		super();
		this.documentResponse = documentResponse;
	}
	public DocumentResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
