package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RetenuSourceResponseFindById
{
	private RetenuSourceResponse retenuSourceResponse;
	private String message;
	public RetenuSourceResponseFindById(RetenuSourceResponse retenuSourceResponse)
	{
		super();
		this.retenuSourceResponse = retenuSourceResponse;
	}
	public RetenuSourceResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
