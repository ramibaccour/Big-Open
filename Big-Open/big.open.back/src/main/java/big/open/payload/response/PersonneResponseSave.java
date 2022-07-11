package big.open.payload.response;
import big.open.payload.response.error.PersonneResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneResponseSave
{
	private PersonneResponse personneResponse;
	private PersonneResponseError personneResponseError;
	private String message;
	public PersonneResponseSave(PersonneResponse personneResponse)
	{
		super();
		this.personneResponse = personneResponse;
	}
	public PersonneResponseSave(PersonneResponseError personneResponseError) 
	{
		super();
		this.personneResponseError = personneResponseError;
	}
	public PersonneResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
