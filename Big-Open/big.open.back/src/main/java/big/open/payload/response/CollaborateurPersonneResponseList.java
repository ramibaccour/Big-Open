package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurPersonneResponseList
{
	private List<CollaborateurPersonneResponse> listCollaborateurPersonneResponse;
	private Long count;
	private String message;
	public CollaborateurPersonneResponseList(List<CollaborateurPersonneResponse> listCollaborateurPersonneResponse, Long count)
	{
		super();
		this.listCollaborateurPersonneResponse = listCollaborateurPersonneResponse;
		this.count = count;
	}
}
