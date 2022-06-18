package big.open.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class User 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String username;
	private String password;
	private Integer IdSociete;
	private Integer isDeleted;

}
