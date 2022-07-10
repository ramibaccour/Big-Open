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
public class DetailDocumentRequest
{
	private Integer page;
	private Integer size;
	private Integer id;
	private String nomArticle;
	private String referenceInterne;
	private String nomUnite;
	private double quantiteArticle;
	private double articlePrix;
	private Integer tauxTva;
	private double totalHt;
	private ArticleRequest article;
	private DocumentRequest document;
	public DetailDocumentRequest(Integer id)
	{
		super();
		this.id = id;
	}
}
