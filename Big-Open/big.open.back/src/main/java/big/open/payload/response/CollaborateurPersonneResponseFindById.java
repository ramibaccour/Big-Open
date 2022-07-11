package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurPersonneResponseFindById
{
	private CollaborateurPersonneResponse collaborateurPersonneResponse;
	private String message;
	public CollaborateurPersonneResponseFindById(CollaborateurPersonneResponse collaborateurPersonneResponse)
	{
		super();
		this.collaborateurPersonneResponse = collaborateurPersonneResponse;
	}
	public CollaborateurPersonneResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
