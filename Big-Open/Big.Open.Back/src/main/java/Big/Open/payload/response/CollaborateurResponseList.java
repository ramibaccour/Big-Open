package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CollaborateurResponseList
{
	private List<CollaborateurResponse> listCollaborateurResponse;
	private Long count;
	private String message;
	public CollaborateurResponseList(List<CollaborateurResponse> listCollaborateurResponse, Long count)
	{
		super();
		this.listCollaborateurResponse = listCollaborateurResponse;
		this.count = count;
	}
}
