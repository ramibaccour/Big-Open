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
import big.open.payload.request.ModuleRequest;
import big.open.payload.response.ModuleResponseFindById;
import big.open.payload.response.ModuleResponseSave;
import big.open.service.ModuleService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/module")
public class ModuleController 
{
	@Autowired
	ModuleService moduleService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<ModuleResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(moduleService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<ModuleResponseSave> save(@Valid @RequestBody ModuleRequest moduleRequest) 
	{
		return ResponseEntity.ok(moduleService.save(moduleRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(moduleService.delete(id));
	}
}
