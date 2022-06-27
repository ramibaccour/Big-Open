package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BanqueResponseList
{
	private List<BanqueResponse> listBanqueResponse;
	private Long count;
	private String message;
	public BanqueResponseList(List<BanqueResponse> listBanqueResponse, Long count)
	{
		super();
		this.listBanqueResponse = listBanqueResponse;
		this.count = count;
	}
}
