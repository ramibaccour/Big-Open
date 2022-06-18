package big.open.payload.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserRequestList 
{
	private Integer page;
	private Integer size;
	private int id;
	private String username;
	private String password;
	private int IdSociete;
}
