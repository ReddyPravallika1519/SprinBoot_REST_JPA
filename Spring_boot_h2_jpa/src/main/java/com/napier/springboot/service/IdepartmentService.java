package com.napier.springboot.service;
import java.util.List;
import java.util.Optional;
import com.napier.springboot.entity.Department;

public interface IdepartmentService {	
	public Department addDepartment(Department dept) ;
	public List<Department> getAll();
	public  Optional<Department> getById(long id);
	public String deleteById(long id) ;
	public Department updateById(long id, Department data);
	public List<Department> findByName(String name);
	public List<Department> findByCode(String dCode);
	public List<Department> findAllByDepartmentIdAndDepartmentName(long id, String name);
	//public List<DepatrmentDto> customQuery() { return idd.customQuery();
	
}
