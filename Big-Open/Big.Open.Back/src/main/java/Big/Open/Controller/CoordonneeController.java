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
import big.open.payload.request.CoordonneeRequest;
import big.open.payload.response.CoordonneeResponseFindById;
import big.open.payload.response.CoordonneeResponseSave;
import big.open.service.CoordonneeService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/coordonnee")
public class CoordonneeController 
{
	@Autowired
	CoordonneeService coordonneeService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<CoordonneeResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(coordonneeService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<CoordonneeResponseSave> save(@Valid @RequestBody CoordonneeRequest coordonneeRequest) 
	{
		return ResponseEntity.ok(coordonneeService.save(coordonneeRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(coordonneeService.delete(id));
	}
}
