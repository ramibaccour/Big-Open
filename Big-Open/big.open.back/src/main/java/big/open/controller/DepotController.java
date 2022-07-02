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
import big.open.payload.request.DepotRequest;
import big.open.payload.response.DepotResponseFindById;
import big.open.payload.response.DepotResponseSave;
import big.open.service.DepotService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/depot")
public class DepotController 
{
	@Autowired
	DepotService depotService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DepotResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(depotService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DepotResponseSave> save(@Valid @RequestBody DepotRequest depotRequest) 
	{
		return ResponseEntity.ok(depotService.save(depotRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(depotService.delete(id));
	}
}
