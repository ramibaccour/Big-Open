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
public class CollaborateurPersonneResponse
{
	private Integer id;
	private CollaborateurResponse collaborateur;
	private PersonneResponse personne;
	public CollaborateurPersonneResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
