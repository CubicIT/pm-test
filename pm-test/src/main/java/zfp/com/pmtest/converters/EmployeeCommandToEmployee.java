package zfp.com.pmtest.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.entity.Employee;

@Component
public class EmployeeCommandToEmployee implements Converter<EmployeeCommand, Employee> {

	private ProjectCommandToProject projectConverter;
	private EmployeeInfoCommandToEmployeeInfo employeeInfoConverter;

	public EmployeeCommandToEmployee(ProjectCommandToProject projectConverter,
			EmployeeInfoCommandToEmployeeInfo employeeInfoConverter) {
		super();
		this.projectConverter = projectConverter;
		this.employeeInfoConverter = employeeInfoConverter;
	}

	@Synchronized
	@Nullable
	@Override
	public Employee convert(EmployeeCommand source) {
		if (source == null) {
			return null;
		}

		final Employee employee = new Employee();
		employee.setId(source.getId());
		employee.setFirstName(source.getFirstName());
		employee.setLastName(source.getLastName());
		employee.setDob(source.getDob());
		employee.setHiringDate(source.getHiringDate());
		employee.setTerminationDate(source.getTerminationDate());
		employee.setEmail(source.getEmail());
		employee.setTelephone(source.getTelephone());
		employee.setJobTitle(source.getJobTitle());
		employee.setEmpInfo(employeeInfoConverter.convert(source.getEmpInfo()));

		if (source.getProjects() != null && source.getProjects().size() > 0) {
			source.getProjects()
			       .forEach(project -> employee.getProjects().add(projectConverter.convert(project)));
		}

		return employee;
	}
}
