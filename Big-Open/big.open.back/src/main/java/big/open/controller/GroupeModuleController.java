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
import big.open.payload.request.GroupeModuleRequest;
import big.open.payload.response.GroupeModuleResponseFindById;
import big.open.payload.response.GroupeModuleResponseSave;
import big.open.service.GroupeModuleService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/groupeModule")
public class GroupeModuleController 
{
	@Autowired
	GroupeModuleService groupeModuleService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<GroupeModuleResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(groupeModuleService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<GroupeModuleResponseSave> save(@Valid @RequestBody GroupeModuleRequest groupeModuleRequest) 
	{
		return ResponseEntity.ok(groupeModuleService.save(groupeModuleRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(groupeModuleService.delete(id));
	}
}
