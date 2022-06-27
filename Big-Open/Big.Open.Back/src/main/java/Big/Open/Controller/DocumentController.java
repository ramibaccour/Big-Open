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
import big.open.payload.request.DocumentRequest;
import big.open.payload.response.DocumentResponseFindById;
import big.open.payload.response.DocumentResponseSave;
import big.open.service.DocumentService;
import lombok.AllArgsConstructor;
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/document")
public class DocumentController 
{
	@Autowired
	DocumentService documentService;
	@GetMapping("/findById/{id}")
	public ResponseEntity<DocumentResponseFindById> findById(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(documentService.findById(id));
	}
	@PostMapping("/save")
	public ResponseEntity<DocumentResponseSave> save(@Valid @RequestBody DocumentRequest documentRequest) 
	{
		return ResponseEntity.ok(documentService.save(documentRequest));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(documentService.delete(id));
	}
}
