package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UniteResponseFindById
{
	private UniteResponse uniteResponse;
	private String message;
	public UniteResponseFindById(UniteResponse uniteResponse)
	{
		super();
		this.uniteResponse = uniteResponse;
	}
	public UniteResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
