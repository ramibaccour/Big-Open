package big.open.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.geo.Point;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String prenomLng1;
	private String prenomLng2;
	private String prenomLng3;
	private String civilite;
	private String type;
	private List<CollaborateurPersonneRequest> listCollaborateurPersonne;
	private List<UserRequest> listUser;
	public PersonneRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
