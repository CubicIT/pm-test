package zfp.com.pmtest.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.commands.EmployeeInfoCommand;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.entity.EmployeeInfo;

@Component
public class EmployeeInfoToEmployeeInfoCommand implements Converter<EmployeeInfo, EmployeeInfoCommand> {

     
    @Synchronized
    @Nullable
    @Override
    public  EmployeeInfoCommand convert(EmployeeInfo empInfo) {
        if (empInfo == null) {
            return null;
        }

        final EmployeeInfoCommand employeeInfoCommand = new EmployeeInfoCommand();
        
        employeeInfoCommand.setId(empInfo.getId());
        employeeInfoCommand.setUserName(empInfo.getUserName());
        employeeInfoCommand.setPassword(empInfo.getPassword());
        employeeInfoCommand.setEvaluation(empInfo.getEvaluation());
        employeeInfoCommand.setRole(empInfo.getRole());
        employeeInfoCommand.setSalary(empInfo.getSalary());
        employeeInfoCommand.setScn(empInfo.getScn());
    	
        return employeeInfoCommand;
    }
}
