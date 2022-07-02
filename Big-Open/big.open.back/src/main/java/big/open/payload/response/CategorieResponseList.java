package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorieResponseList
{
	private List<CategorieResponse> listCategorieResponse;
	private Long count;
	private String message;
	public CategorieResponseList(List<CategorieResponse> listCategorieResponse, Long count)
	{
		super();
		this.listCategorieResponse = listCategorieResponse;
		this.count = count;
	}
}
