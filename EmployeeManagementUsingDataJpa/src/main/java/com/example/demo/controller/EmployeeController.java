package com.example.demo.controller;

import java.util.List;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController 
// @Responsebody + @Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {// http://localhost:2345/employees

	
	EmployeeService service;

	@GetMapping("/message") // http://localhost:2345/employees/message
	public String getMessage() {
		return "Leave us we are getting sleep!!";
	}

	@PostMapping("/save") // http://localhost:2345/employees/save
	public String createEmployee(@RequestBody @Validated Employee employee) {
		return service.saveEmployee(employee);
	}

	@PutMapping("/update")
	public String updatingEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:2345/employees/delete/123
	public String removeEmployee(@PathVariable("id") int empId) {
		return service.deleteEmployee(empId);
	}

	@GetMapping("/fetch/{id}") // http://localhost:2345/employees/fetch/123
	public Employee getEmployee(@PathVariable("id") int empId) throws EmployeeNotFound {
		return service.getEmployee(empId);

	}

	@GetMapping("/fetchAll") // http://localhost:2345/employees/fetchAll
	public List<Employee> getAllEmployee() {
		return service.getAllEmployees();
	}

	@GetMapping("/fetchAllByDesg/{empDesg}") // http://localhost:2345/employees/fetchAllByDesg
	public List<Employee> getEmployeesDesg(@PathVariable("empDesg") String empDesg) {
		return service.getEmployeeByDesg(empDesg);
	}

	@GetMapping("/fetchAllBetween") // http://localhost:2345/employees/fetch/123
	public List<Employee> getAllEmployee(@RequestParam("sal1") int initialSal, @RequestParam("sal2") int finalSal) {
		return service.getAllEmployees();
	}

}
