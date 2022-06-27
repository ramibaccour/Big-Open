package big.open.payload.response;
import big.open.payload.response.error.TvaResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TvaResponseSave
{
	private TvaResponse tvaResponse;
	private TvaResponseError tvaResponseError;
	private String message;
	public TvaResponseSave(TvaResponse tvaResponse)
	{
		super();
		this.tvaResponse = tvaResponse;
	}
	public TvaResponseSave(TvaResponseError tvaResponseError) 
	{
		super();
		this.tvaResponseError = tvaResponseError;
	}
	public TvaResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
