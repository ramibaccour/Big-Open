package big.open.payload.response;
import big.open.payload.response.error.ValeurCarateristiqueResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValeurCarateristiqueResponseSave
{
	private ValeurCarateristiqueResponse valeurCarateristiqueResponse;
	private ValeurCarateristiqueResponseError valeurCarateristiqueResponseError;
	private String message;
	public ValeurCarateristiqueResponseSave(ValeurCarateristiqueResponse valeurCarateristiqueResponse)
	{
		super();
		this.valeurCarateristiqueResponse = valeurCarateristiqueResponse;
	}
	public ValeurCarateristiqueResponseSave(ValeurCarateristiqueResponseError valeurCarateristiqueResponseError) 
	{
		super();
		this.valeurCarateristiqueResponseError = valeurCarateristiqueResponseError;
	}
	public ValeurCarateristiqueResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
