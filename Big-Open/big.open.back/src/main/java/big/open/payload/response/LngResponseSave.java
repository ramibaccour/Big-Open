package big.open.payload.response;
import big.open.payload.response.error.LngResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponseSave
{
	private LngResponse lngResponse;
	private LngResponseError lngResponseError;
	private String message;
	public LngResponseSave(LngResponse lngResponse)
	{
		super();
		this.lngResponse = lngResponse;
	}
	public LngResponseSave(LngResponseError lngResponseError) 
	{
		super();
		this.lngResponseError = lngResponseError;
	}
	public LngResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
