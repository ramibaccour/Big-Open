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
public class MenuResponse
{
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
	private MenuResponse menu;
	private List<MenuResponse> listMenu;
	private List<ModuleResponse> listModule;
	public MenuResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
