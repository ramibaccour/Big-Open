package big.open.payload.response;
import big.open.payload.response.error.DetailGroupeModuleResponseError;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetailGroupeModuleResponseSave
{
	private DetailGroupeModuleResponse detailGroupeModuleResponse;
	private DetailGroupeModuleResponseError detailGroupeModuleResponseError;
	private String message;
	public DetailGroupeModuleResponseSave(DetailGroupeModuleResponse detailGroupeModuleResponse)
	{
		super();
		this.detailGroupeModuleResponse = detailGroupeModuleResponse;
	}
	public DetailGroupeModuleResponseSave(DetailGroupeModuleResponseError detailGroupeModuleResponseError) 
	{
		super();
		this.detailGroupeModuleResponseError = detailGroupeModuleResponseError;
	}
	public DetailGroupeModuleResponseSave(String message) 
	{
		super();
		this.message = message;
	}
}
