package big.open.payload.response;
import big.open.payload.response.error.CaisseResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaisseResponseSave
{
	private CaisseResponse caisseResponse;
	private CaisseResponseError caisseResponseError;
	private String message;
	public CaisseResponseSave(CaisseResponse caisseResponse)
	{
		super();
		this.caisseResponse = caisseResponse;
	}
	public CaisseResponseSave(CaisseResponseError caisseResponseError) 
	{
		super();
		this.caisseResponseError = caisseResponseError;
	}
	public CaisseResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
