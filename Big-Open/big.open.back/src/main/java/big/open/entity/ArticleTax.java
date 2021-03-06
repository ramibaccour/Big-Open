package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;
import org.springframework.data.geo.Point;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "article_tax")
public class ArticleTax 
{
	@NotNull()
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Transient
	private Tax tax;
	@Transient
	private Article article;
}
