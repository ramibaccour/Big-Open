package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentResponseFindById
{
	private DetailDocumentResponse detailDocumentResponse;
	private String message;
	public DetailDocumentResponseFindById(DetailDocumentResponse detailDocumentResponse)
	{
		super();
		this.detailDocumentResponse = detailDocumentResponse;
	}
	public DetailDocumentResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
