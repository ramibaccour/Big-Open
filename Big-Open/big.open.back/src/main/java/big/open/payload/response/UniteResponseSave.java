package big.open.payload.response;
import big.open.payload.response.error.UniteResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniteResponseSave
{
	private UniteResponse uniteResponse;
	private UniteResponseError uniteResponseError;
	private String message;
	public UniteResponseSave(UniteResponse uniteResponse)
	{
		super();
		this.uniteResponse = uniteResponse;
	}
	public UniteResponseSave(UniteResponseError uniteResponseError) 
	{
		super();
		this.uniteResponseError = uniteResponseError;
	}
	public UniteResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
