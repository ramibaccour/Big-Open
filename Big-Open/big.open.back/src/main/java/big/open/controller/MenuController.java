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
import big.open.payload.request.MenuRequest;
import big.open.payload.response.MenuResponseFindById;
import big.open.payload.response.MenuResponseSave;
import big.open.service.MenuService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/menu")
public class MenuController 
{
	@Autowired
	MenuService menuService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<MenuResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(menuService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<MenuResponseSave> save(@Valid @RequestBody MenuRequest menuRequest) 
	{
		return ResponseEntity.ok(menuService.save(menuRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(menuService.delete(id));
	}
}
