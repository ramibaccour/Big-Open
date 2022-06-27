package big.open.payload.response;
import big.open.payload.response.error.CollaborateurResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurResponseSave
{
	private CollaborateurResponse collaborateurResponse;
	private CollaborateurResponseError collaborateurResponseError;
	private String message;
	public CollaborateurResponseSave(CollaborateurResponse collaborateurResponse)
	{
		super();
		this.collaborateurResponse = collaborateurResponse;
	}
	public CollaborateurResponseSave(CollaborateurResponseError collaborateurResponseError) 
	{
		super();
		this.collaborateurResponseError = collaborateurResponseError;
	}
	public CollaborateurResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
