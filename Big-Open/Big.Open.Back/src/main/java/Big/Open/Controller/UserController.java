package big.open.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController 
{
//	@GetMapping("/findById/{id}")
//	public ResponseEntity<ArticleResponseFindById> findById(@PathVariable("id") String id) 
//	{
//		return ResponseEntity.ok(articleService.findById(id));
//	}
}
