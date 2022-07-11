package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneResponseFindById
{
	private PersonneResponse personneResponse;
	private String message;
	public PersonneResponseFindById(PersonneResponse personneResponse)
	{
		super();
		this.personneResponse = personneResponse;
	}
	public PersonneResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
