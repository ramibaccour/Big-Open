package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxResponseFindById
{
	private TaxResponse taxResponse;
	private String message;
	public TaxResponseFindById(TaxResponse taxResponse)
	{
		super();
		this.taxResponse = taxResponse;
	}
	public TaxResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
