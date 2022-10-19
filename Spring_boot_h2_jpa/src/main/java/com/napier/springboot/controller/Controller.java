package com.napier.springboot.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.napier.springboot.entity.Department;
import com.napier.springboot.service.DepartmentServiceImpl;

@RestController
public class Controller {

	@Autowired
	private DepartmentServiceImpl dsi; // field type autowiring

	@PostMapping("/put")
	public Department addDepartment(@RequestBody Department dept) {
		return dsi.addDepartment(dept);
	}

	@GetMapping("/get")
	public Iterable<Department> getAllDepartmentData() {
		return dsi.getAll();
	}

	@GetMapping("/getbyId/{id}")
	public Optional<Department> getDeptById(@PathVariable long id) {
		return dsi.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		return dsi.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public Department updateById(@PathVariable long id, @RequestBody Department data) {
		return dsi.updateById(id, data);
	}

	@GetMapping("/getByName/{name}")
	public List<Department> findDeptByName(@PathVariable String name) {
		return dsi.findByName(name);
	}
	
	@GetMapping("/getByCode/{code}")
	public List<Department> findAllByDepartmentCode(@PathVariable String code)
	{
		return dsi.findByCode(code);
	}
	
	@GetMapping("/getByIdAndName/{id}/{name}")
	public List<Department> findAllByDepartmentIdAndDepartmentName(@PathVariable long id, @PathVariable String name)
	{
		return dsi.findAllByDepartmentIdAndDepartmentName(id, name);
	}
	
	
	
	  //custom query
	  
	  @GetMapping("/custom") public List<Department> customQuery() { return
	  dsi.customQuery(); }
	 
	
	
	
}
