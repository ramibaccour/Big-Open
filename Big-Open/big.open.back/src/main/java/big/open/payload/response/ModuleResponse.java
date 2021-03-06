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
public class ModuleResponse
{
	private Integer id;
	private String nomLng1;
	private String nomLng2;
	private String nomLng3;
	private MenuResponse menu;
	private ModuleResponse module;
	private List<DetailGroupeModuleResponse> listDetailGroupeModule;
	private List<ModuleResponse> listModule;
	public ModuleResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
