package com.MainApp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MainApp.Entity.Employee;
import com.MainApp.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository eRepo;

	public void addEmp(Employee e) {

		eRepo.save(e);
	}
	
	public List<Employee> readAll()
	{
		List<Employee> l = eRepo.findAll();
		return l;
	}
	
	public Optional<Employee> getEmp(int id)
	{
		Optional<Employee> e = eRepo.findById(id);
		return e;
		
	}
	

	public String deleteEmployee(int id)
	{
		Optional<Employee> e = eRepo.findById(id);
		if (e.isPresent()) {
			eRepo.delete(e.get());
			return "delete success";
		}
		else {
			return "doesent exist";
		}
	}
	
	public String editEmployee( Employee emp)
	{
		Optional<Employee> e = eRepo.findById(emp.getId());
		if (e.isPresent()) {
			eRepo.save(emp);
			return "Update success";
		}
		else {
			return "doesent exist";
		}
	}
	
}
