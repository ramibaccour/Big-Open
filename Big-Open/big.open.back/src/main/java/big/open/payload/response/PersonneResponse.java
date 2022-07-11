package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.time.LocalDateTime;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String prenomLng1;
	private String prenomLng2;
	private String prenomLng3;
	private String civilite;
	private String type;
	private List<CollaborateurPersonneResponse> listCollaborateurPersonne;
	private List<UserResponse> listUser;
	public PersonneResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
