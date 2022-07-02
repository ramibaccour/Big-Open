package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxResponseList
{
	private List<TaxResponse> listTaxResponse;
	private Long count;
	private String message;
	public TaxResponseList(List<TaxResponse> listTaxResponse, Long count)
	{
		super();
		this.listTaxResponse = listTaxResponse;
		this.count = count;
	}
}
