package big.open.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "user")
public class User 
{
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	private String username;
	private String password;
	@Column(name="id_societe")
	private Integer idSociete;
	@Column(name="is_deleted")
	private Integer isDeleted;

}
