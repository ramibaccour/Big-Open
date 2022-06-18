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
import big.open.payload.request.UserRequest;
import big.open.payload.response.UserResponseFindById;
import big.open.payload.response.UserResponseSave;
import big.open.service.UserService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
	UserService userService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<UserResponseFindById> findById(@PathVariable("id") Integer id) 
	{
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserResponseSave> save(@Valid @RequestBody UserRequest userRequest) 
	{
		return ResponseEntity.ok(userService.save(userRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(userService.delete(id));
	}
}
