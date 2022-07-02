package big.open.payload.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailGroupeModuleResponseFindById
{
	private DetailGroupeModuleResponse detailGroupeModuleResponse;
	private String message;
	public DetailGroupeModuleResponseFindById(DetailGroupeModuleResponse detailGroupeModuleResponse)
	{
		super();
		this.detailGroupeModuleResponse = detailGroupeModuleResponse;
	}
	public DetailGroupeModuleResponseFindById(String message) 
	{
		super();
		this.message = message;
	}
}
