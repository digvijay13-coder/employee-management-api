package com.MainApp.Controller;

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

import com.MainApp.Entity.Employee;
import com.MainApp.Service.EmployeeService;

@RestController
public class MyController {

	@Autowired
	EmployeeService eService;
	
	//localhost:8081/add
	
	@PostMapping("/add")
	public String handleAdd(@RequestBody Employee e)
	{
		eService.addEmp(e);
		return "Added";
	}
	
	//localhost://8081/readall
	@GetMapping("/readall")
	public List<Employee> handleReadAll()
	{
		List<Employee> l = eService.readAll();
		return l;
	}
	
	
	//localhost://8081/readbyid/777
	@GetMapping("/readbyid/{id}")
	public Employee handleReadById(@PathVariable("id") int id)
	{
		Optional<Employee> emp = eService.getEmp(id);
		return emp.get();
	}
	
	//localhost://delete/777
	@DeleteMapping("/delete/{id}")
	public String handelDeleteEmp(@PathVariable int id)
	{
		return eService.deleteEmployee(id);
	}
	
	//localhost:8081:/edit
	@PutMapping("edit")
	public String handleEditEmp(@RequestBody Employee e )
	{
		return eService.editEmployee(e);
	}

	
	
}
