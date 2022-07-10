package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LngResponseError
{
	private String id;
	private String name;
	private String rtl;
	private String byDefault;
	private String code;
	private boolean haveError;
}
