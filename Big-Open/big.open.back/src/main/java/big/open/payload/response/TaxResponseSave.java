package big.open.payload.response;
import big.open.payload.response.error.TaxResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaxResponseSave
{
	private TaxResponse taxResponse;
	private TaxResponseError taxResponseError;
	private String message;
	public TaxResponseSave(TaxResponse taxResponse)
	{
		super();
		this.taxResponse = taxResponse;
	}
	public TaxResponseSave(TaxResponseError taxResponseError) 
	{
		super();
		this.taxResponseError = taxResponseError;
	}
	public TaxResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
