package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValeurCarateristiqueResponseFindById
{
	private ValeurCarateristiqueResponse valeurCarateristiqueResponse;
	private String message;
	public ValeurCarateristiqueResponseFindById(ValeurCarateristiqueResponse valeurCarateristiqueResponse)
	{
		super();
		this.valeurCarateristiqueResponse = valeurCarateristiqueResponse;
	}
	public ValeurCarateristiqueResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
