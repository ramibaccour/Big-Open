package big.open.payload.response;
import big.open.payload.response.error.MonnaieResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MonnaieResponseSave
{
	private MonnaieResponse monnaieResponse;
	private MonnaieResponseError monnaieResponseError;
	private String message;
	public MonnaieResponseSave(MonnaieResponse monnaieResponse)
	{
		super();
		this.monnaieResponse = monnaieResponse;
	}
	public MonnaieResponseSave(MonnaieResponseError monnaieResponseError) 
	{
		super();
		this.monnaieResponseError = monnaieResponseError;
	}
	public MonnaieResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
