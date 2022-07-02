package big.open.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import big.open.payload.request.BanqueRequest;
import big.open.payload.response.BanqueResponseFindById;
import big.open.payload.response.BanqueResponseSave;
import big.open.service.BanqueService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/banque")
public class BanqueController 
{
	@Autowired
	BanqueService banqueService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<BanqueResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(banqueService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<BanqueResponseSave> save(@Valid @RequestBody BanqueRequest banqueRequest) 
	{
		return ResponseEntity.ok(banqueService.save(banqueRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(banqueService.delete(id));
	}
}
