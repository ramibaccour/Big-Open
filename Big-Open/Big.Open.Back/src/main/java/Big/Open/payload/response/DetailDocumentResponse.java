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
public class DetailDocumentResponse
{
	private Integer id;
	private String nomArticle;
	private String referenceInterne;
	private String nomUnite;
	private double quantiteArticle;
	private double articlePrix;
	private Integer tauxTva;
	private double totalHt;
	private ArticleResponse articleResponse;
	private DocumentResponse documentResponse;
	public DetailDocumentResponse(Integer id)
	{
		super();
		this.id = id;
	}
}
