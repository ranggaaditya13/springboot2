package com.rangga.Controller;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.CrossOrigin;  
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;

import com.rangga.Service.PositionService;
import com.rangga.entity.PositionEntity;  

@RestController  
@CrossOrigin(origins="http://localhost:8080")  
public class PositionController {
	
	@Autowired
	private PositionService service;
	
	  @PostMapping("/add")  
	    public boolean savePosition(@RequestBody PositionEntity Position) {  
	         return service.savePosition(Position);  
	          
	    }  
	      
	    @GetMapping("/list")  
	    public List<PositionEntity> allPositions() {  
	         return service.getPosition();  
	          
	    }  
	      
	    @PostMapping("delete/{id}")  
	    public boolean deletePosition(@PathVariable("id") int id,PositionEntity Position) {  
	        Position.setId(id);  
	        return service.deletePosition(Position);  
	    }  
	  
	    @GetMapping("position/{id}")  
	    public List<PositionEntity> allPositionByID(@PathVariable("id") int id,PositionEntity Position) {  
	         Position.setId(id);
	         return service.getPositionById(Position); 
	          
	    }  
	      
	    @PostMapping("update/{id}")  
	    public boolean updatePosition(@RequestBody PositionEntity Position,@PathVariable("id") int id) {  
	        Position.setId(id);
	        return service.updatePosition(Position);  
	    }  

}
