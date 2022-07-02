package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailDocumentResponseList
{
	private List<DetailDocumentResponse> listDetailDocumentResponse;
	private Long count;
	private String message;
	public DetailDocumentResponseList(List<DetailDocumentResponse> listDetailDocumentResponse, Long count)
	{
		super();
		this.listDetailDocumentResponse = listDetailDocumentResponse;
		this.count = count;
	}
}
