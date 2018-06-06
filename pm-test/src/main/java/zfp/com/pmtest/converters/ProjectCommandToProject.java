package zfp.com.pmtest.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.commands.ProjectCommand;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.entity.Project;

@Component
public class ProjectCommandToProject implements Converter<ProjectCommand, Project> {

    private final EmployeeCommandToEmployee employeeConveter;
    
     public ProjectCommandToProject(EmployeeCommandToEmployee employeeConveter) {
		super();
		this.employeeConveter = employeeConveter;
	}

	@Synchronized
    @Nullable
    @Override
    public Project convert(ProjectCommand source) {
        if (source == null) {
            return null;
        }

        final Project project = new Project();
        project.setId(source.getId());
        project.setCost(source.getCost());
        project.setDescription(source.getDescription());
        project.setEndDate(source.getEndDate());
        project.setName(source.getName());
        project.setProjectType(source.getProjectType());
        project.setStartDate(source.getStartDate());
       
        if (source.getEmployees() != null && source.getEmployees().size() > 0){
            source.getEmployees()
                    .forEach( employee -> project.getEmployees().add(employeeConveter.convert(employee)));
        }

         return project;
    }
}
