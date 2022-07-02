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
public class RetenuSourceRequest
{
	private Integer id;
	private Integer taux;
	private String type;
	private List<ReglementRequest> listReglement;
	public RetenuSourceRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
