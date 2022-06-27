package big.open.payload.response;
import big.open.payload.response.error.MarqueResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MarqueResponseSave
{
	private MarqueResponse marqueResponse;
	private MarqueResponseError marqueResponseError;
	private String message;
	public MarqueResponseSave(MarqueResponse marqueResponse)
	{
		super();
		this.marqueResponse = marqueResponse;
	}
	public MarqueResponseSave(MarqueResponseError marqueResponseError) 
	{
		super();
		this.marqueResponseError = marqueResponseError;
	}
	public MarqueResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
