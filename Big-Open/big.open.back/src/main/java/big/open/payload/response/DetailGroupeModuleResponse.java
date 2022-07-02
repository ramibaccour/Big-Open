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
public class DetailGroupeModuleResponse
{
	private Integer id;
	private boolean valeur;
	private GroupeModuleResponse groupeModuleResponse;
	private ModuleResponse moduleResponse;
	public DetailGroupeModuleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
