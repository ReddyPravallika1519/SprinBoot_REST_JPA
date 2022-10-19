package com.napier.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.napier.springboot.dao.IDepartmentDao;
import com.napier.springboot.entity.Department;

@Service
public class DepartmentServiceImpl implements IdepartmentService {

	@Autowired
	private IDepartmentDao idd;

	public Department addDepartment(Department dept) {
		return idd.save(dept);
	}

	public List<Department> getAll() {
		return (List<Department>) idd.findAll();
	}

	public Optional<Department> getById(long id) {
		return idd.findById(id);
	}

	public String deleteById(long id) {
		idd.deleteById(id);
		return id + " deleted successfully";
	}

	public Department updateById(long id, Department data) {
		Department idObj = idd.findById(id).get();
		if (data.getDepartmentName() != null && !("").equalsIgnoreCase(data.getDepartmentName())) {
			idObj.setDepartmentName(data.getDepartmentName());
		}
		if (data.getDepartmentCode() != null && !("").equalsIgnoreCase(data.getDepartmentCode())) {
			idObj.setDepartmentCode(data.getDepartmentCode());
		}
		return idd.save(idObj);

	}

	// THERE is no method directly for findbyname, so we defined it in dao
	// interface. There are some keywords we can use with findBy...
	// refer the doc
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
	public List<Department> findByName(String name) {
		return idd.findAllByDepartmentNameIgnoreCase(name);
	}

	public List<Department> findByCode(String dCode)
	{
		return idd.findAllByDepartmentCode(dCode);
	}
	
	public List<Department> findAllByDepartmentIdAndDepartmentName(long id, String name)
	{
		return idd.findAllByDepartmentIdAndDepartmentName(id, name);
	}
	
	
	
	 public List<Department> customQuery() { return idd.customQuery(); } 
	 
	
}
