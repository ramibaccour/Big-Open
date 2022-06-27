package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurResponseFindById
{
	private CollaborateurResponse collaborateurResponse;
	private String message;
	public CollaborateurResponseFindById(CollaborateurResponse collaborateurResponse)
	{
		super();
		this.collaborateurResponse = collaborateurResponse;
	}
	public CollaborateurResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
