package big.open.payload.response;
import big.open.payload.response.error.RetenuSourceResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetenuSourceResponseSave
{
	private RetenuSourceResponse retenuSourceResponse;
	private RetenuSourceResponseError retenuSourceResponseError;
	private String message;
	public RetenuSourceResponseSave(RetenuSourceResponse retenuSourceResponse)
	{
		super();
		this.retenuSourceResponse = retenuSourceResponse;
	}
	public RetenuSourceResponseSave(RetenuSourceResponseError retenuSourceResponseError) 
	{
		super();
		this.retenuSourceResponseError = retenuSourceResponseError;
	}
	public RetenuSourceResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
