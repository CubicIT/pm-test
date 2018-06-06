package zfp.com.pmtest.services;


import java.util.Set;

import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.entity.Employee;


public interface EmployeeService {

	Set<Employee> getEmployees();

	Employee findById(int id);

	EmployeeCommand findCommandById(Integer id);

	EmployeeCommand saveEmployeeCommand(EmployeeCommand command);
}

