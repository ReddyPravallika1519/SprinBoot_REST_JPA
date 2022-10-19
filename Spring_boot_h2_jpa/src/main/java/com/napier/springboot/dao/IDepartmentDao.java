package com.napier.springboot.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.napier.springboot.entity.Department;

@Repository

public interface IDepartmentDao extends JpaRepository<Department, Long> {
	// this interface is having all curd related methods like save, findById, etc
	
	//IgnoreCase
	public List<Department> findAllByDepartmentNameIgnoreCase(String dName);
	

	public List<Department> findAllByDepartmentCode(String dCode);
	
	//And
	public List<Department> findAllByDepartmentIdAndDepartmentName(long id, String name);

	
	  @Modifying
	  
	  @Query("select u from Department u") public List<Department>
	  customQuery();
	 
	 
	
}

