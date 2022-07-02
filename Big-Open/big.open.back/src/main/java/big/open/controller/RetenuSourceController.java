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
import big.open.payload.request.RetenuSourceRequest;
import big.open.payload.response.RetenuSourceResponseFindById;
import big.open.payload.response.RetenuSourceResponseSave;
import big.open.service.RetenuSourceService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/retenu_source")
public class RetenuSourceController 
{
	@Autowired
	RetenuSourceService retenuSourceService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<RetenuSourceResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(retenuSourceService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<RetenuSourceResponseSave> save(@Valid @RequestBody RetenuSourceRequest retenuSourceRequest) 
	{
		return ResponseEntity.ok(retenuSourceService.save(retenuSourceRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(retenuSourceService.delete(id));
	}
}
