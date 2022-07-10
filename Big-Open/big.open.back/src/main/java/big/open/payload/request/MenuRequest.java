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
public class MenuRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private String icon;
	private String componont;
	private String routerlink;
	private boolean selected;
	private String selectedColor;
	private String color;
	private Integer order;
	private MenuRequest menu;
	private List<MenuRequest> listMenu;
	private List<ModuleRequest> listModule;
	public MenuRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
