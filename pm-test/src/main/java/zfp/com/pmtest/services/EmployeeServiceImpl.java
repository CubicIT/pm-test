package zfp.com.pmtest.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.converters.EmployeeCommandToEmployee;
import zfp.com.pmtest.converters.EmployeeToEmployeeCommand;
import zfp.com.pmtest.dao.EmployeeRepository;
import zfp.com.pmtest.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final EmployeeCommandToEmployee employeeCommandToEmployee;
	private final EmployeeToEmployeeCommand employeeToEmployeeeCommand;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository,
			EmployeeCommandToEmployee employeeCommandToEmployee, EmployeeToEmployeeCommand employeeToEmployeeeCommand) {
		super();
		this.employeeRepository = employeeRepository;
		this.employeeCommandToEmployee = employeeCommandToEmployee;
		this.employeeToEmployeeeCommand = employeeToEmployeeeCommand;
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> employeeOptional = employeeRepository.findById(id);

		if (!employeeOptional.isPresent()) {
			throw new RuntimeException("Employee Not Found!");
		}

		return employeeOptional.get();
	}

	@Override
	public Set<Employee> getEmployees() {
		Set<Employee> employeeSet = new HashSet<>();
		employeeRepository.findAll().iterator().forEachRemaining(employeeSet::add);
		return employeeSet;
	}

	@Override
	@Transactional
	public EmployeeCommand findCommandById(Integer id) {
		return employeeToEmployeeeCommand.convert(findById(id));
	}

	@Override
	@Transactional
	public EmployeeCommand saveEmployeeCommand(EmployeeCommand command) {
		Employee detachedEmployee = employeeCommandToEmployee.convert(command);

		Employee savedEmployee = employeeRepository.save(detachedEmployee);
		// log.debug("Saved RecipeId:" + savedRecipe.getId());
		return employeeToEmployeeeCommand.convert(savedEmployee);
	}
}
