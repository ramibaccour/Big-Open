package big.open.payload.response;
import big.open.payload.response.error.CollaborateurPersonneResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurPersonneResponseSave
{
	private CollaborateurPersonneResponse collaborateurPersonneResponse;
	private CollaborateurPersonneResponseError collaborateurPersonneResponseError;
	private String message;
	public CollaborateurPersonneResponseSave(CollaborateurPersonneResponse collaborateurPersonneResponse)
	{
		super();
		this.collaborateurPersonneResponse = collaborateurPersonneResponse;
	}
	public CollaborateurPersonneResponseSave(CollaborateurPersonneResponseError collaborateurPersonneResponseError) 
	{
		super();
		this.collaborateurPersonneResponseError = collaborateurPersonneResponseError;
	}
	public CollaborateurPersonneResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
