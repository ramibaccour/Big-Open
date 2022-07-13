package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="nom_lng1")
	private String nomLng1;
	@Column(name="nom_lng2")
	private String nomLng2;
	@Column(name="nom_lng3")
	private String nomLng3;
	@Column(name="icon")
	private String icon;
	@Column(name="componont")
	private String componont;
	@Column(name="routerlink")
	private String routerlink;
	@Column(name="selected")
	private boolean selected;
	@Column(name="selected_color")
	private String selectedColor;
	@Column(name="color")
	private String color;
	@Column(name="order")
	private Integer order;
	@Transient
	private Menu menu;
	@Transient
	private List<Menu> listMenu;
	@Transient
	private List<Module> listModule;
}
