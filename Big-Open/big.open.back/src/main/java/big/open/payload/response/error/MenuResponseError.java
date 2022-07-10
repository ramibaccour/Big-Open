package big.open.payload.response.error;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuResponseError
{
	private String id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String icon;
	private String componont;
	private String routerlink;
	private String selected;
	private String selectedColor;
	private String color;
	private String order;
	private boolean haveError;
}
