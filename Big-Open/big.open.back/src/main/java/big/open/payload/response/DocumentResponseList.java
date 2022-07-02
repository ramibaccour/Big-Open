package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentResponseList
{
	private List<DocumentResponse> listDocumentResponse;
	private Long count;
	private String message;
	public DocumentResponseList(List<DocumentResponse> listDocumentResponse, Long count)
	{
		super();
		this.listDocumentResponse = listDocumentResponse;
		this.count = count;
	}
}
