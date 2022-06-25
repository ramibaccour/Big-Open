package big.open.payload.response;
import big.open.payload.response.error.SocieteResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SocieteResponseSave
{
	private SocieteResponse societeResponse;
	private SocieteResponseError societeResponseError;
	private String message;
	public SocieteResponseSave(SocieteResponse societeResponse)
	{
		super();
		this.societeResponse = societeResponse;
	}
	public SocieteResponseSave(SocieteResponseError societeResponseError) 
	{
		super();
		this.societeResponseError = societeResponseError;
	}
	public SocieteResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
