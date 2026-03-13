package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name="cts_emp_info")
@Data // -> combination of @Getter, @Setter, @ToString, @RequiredArgsConstructor, @EqualAndHashCode

@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@Column(name = "empno")
	@Min(value = 1, message = "Employee Id cannot be Negative")
	private int empId;
	@NotBlank(message = "Emp name cannot be Empty/Blank/Null")
	@Column(name="ename", nullable=false, length=10)
	@Size(min = 10, max = 123, message = "Name length must be (10,123)")
	private String empName;
	@Min(value = 1000, message = "Salary cannot be below 1000")
	@Max(value = 1000, message = "Salary cannot be above 10000000")
	private int empSal;
	@NotEmpty(message = "Designation cannot bull/empty")
	private String empDesg;
	
	
}
