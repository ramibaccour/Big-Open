package big.open.payload.response;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonneResponseList
{
	private List<PersonneResponse> listPersonneResponse;
	private Long count;
	private String message;
	public PersonneResponseList(List<PersonneResponse> listPersonneResponse, Long count)
	{
		super();
		this.listPersonneResponse = listPersonneResponse;
		this.count = count;
	}
}
