package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import lombok.NoArgsConstructor;
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
	private Integer menuPrincipale;
	private List<MenuResponse> listMenu;
	private List<ModuleResponse> listModule;
	public MenuResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
