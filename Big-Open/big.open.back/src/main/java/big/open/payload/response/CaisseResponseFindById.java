package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CaisseResponseFindById
{
	private CaisseResponse caisseResponse;
	private String message;
	public CaisseResponseFindById(CaisseResponse caisseResponse)
	{
		super();
		this.caisseResponse = caisseResponse;
	}
	public CaisseResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
