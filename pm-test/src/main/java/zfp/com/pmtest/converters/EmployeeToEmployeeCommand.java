package zfp.com.pmtest.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import lombok.Synchronized;
import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.entity.Project;

public class EmployeeToEmployeeCommand implements Converter<Employee, EmployeeCommand>{

    private final EmployeeInfoToEmployeeInfoCommand employeeInfoConveter;
    private final ProjectToProjectCommand projectConverter;
      
    public EmployeeToEmployeeCommand(EmployeeInfoToEmployeeInfoCommand employeeInfoConveter,
			ProjectToProjectCommand projectConverter) {
		super();
		this.employeeInfoConveter = employeeInfoConveter;
		this.projectConverter = projectConverter;
	}

	@Synchronized
    @Nullable
    @Override
    public EmployeeCommand convert(Employee source) {
        if (source == null) {
            return null;
        }

        final EmployeeCommand command = new EmployeeCommand();
        command.setId(source.getId());
        command.setFirstName(source.getFirstName());
        command.setLastName(source.getLastName());
        command.setDob(source.getDob());
        command.setEmail(source.getEmail());
        command.setHiringDate(source.getHiringDate());
        command.setTerminationDate(source.getTerminationDate());
        command.setTelephone(source.getTelephone());
        command.setEmpInfo(employeeInfoConveter.convert(source.getEmpInfo()));
        
               
        if (source.getProjects() != null && source.getProjects().size() > 0){
            source.getProjects()
                    .forEach((Project project) -> command.getProjects().add(projectConverter.convert(project)));
        }

        return command;
    }

}
