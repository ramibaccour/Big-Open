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
public class RetenuSourceResponse
{
	private Integer id;
	private Integer taux;
	private String type;
	private List<ReglementResponse> listReglementResponse;
	public RetenuSourceResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
