package zfp.com.pmtest.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import zfp.com.pmtest.commands.ProjectCommand;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.entity.Project;

@Component
public class ProjectToProjectCommand implements Converter<Project, ProjectCommand> {

	private final EmployeeToEmployeeCommand employeeConveter;

	public ProjectToProjectCommand(EmployeeToEmployeeCommand employeeConveter) {
		super();
		this.employeeConveter = employeeConveter;
	}

	@Synchronized
	@Nullable
	@Override
	public ProjectCommand convert(Project source) {
		if (source == null) {
			return null;
		}

		final ProjectCommand command = new ProjectCommand();
		command.setId(source.getId());
		command.setCost(source.getCost());
		command.setDescription(source.getDescription());
		command.setEndDate(source.getEndDate());
		command.setName(source.getName());
		command.setProjectType(source.getProjectType());
		command.setStartDate(source.getStartDate());

		if (source.getEmployees() != null && source.getEmployees().size() > 0) {
			source.getEmployees().forEach(employee -> command.getEmployees().add(employeeConveter.convert(employee)));
		}

		return command;
	}
}
