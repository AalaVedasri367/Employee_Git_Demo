package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // persist(), merge(), remove(), find()
																				// -> only for one row operation
//createQuery() ->for multi row operations
//<Employee, Integer> --> enity class and primary key data type

	@Query("select e from Employee e where e.empDesg=?1")
	public abstract List<Employee> getEmployeeByDesg(String empDesg);

	@Query("select e from Employee e where e.empSal between ?1 and ?2")
	public abstract List<Employee> getEmployeeBetweenSal(int initialSal, int finalSal);

}

//Repository
//CrudRepository -> only crud operations basics
//JPARepository -> if you want to go more operations sorting like that...
