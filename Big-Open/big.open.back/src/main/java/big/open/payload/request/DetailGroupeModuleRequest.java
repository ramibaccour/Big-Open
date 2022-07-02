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
public class DetailGroupeModuleRequest
{
	private Integer id;
	private boolean valeur;
	private GroupeModuleRequest groupeModuleRequest;
	private ModuleRequest moduleRequest;
	public DetailGroupeModuleRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
