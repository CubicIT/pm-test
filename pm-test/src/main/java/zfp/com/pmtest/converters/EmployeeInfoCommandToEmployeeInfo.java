package zfp.com.pmtest.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.commands.EmployeeInfoCommand;
import zfp.com.pmtest.entity.EmployeeInfo;
import zfp.com.pmtest.entity.Employee;

@Component
public class EmployeeInfoCommandToEmployeeInfo implements Converter<EmployeeInfoCommand, EmployeeInfo> {

     
    @Synchronized
    @Nullable
    @Override
    public  EmployeeInfo convert(EmployeeInfoCommand source) {
        if (source == null) {
            return null;
        }

        final EmployeeInfo employeeInfo = new EmployeeInfo();
        
        employeeInfo.setId(source.getId());
       	employeeInfo.setUserName(source.getUserName());
    	employeeInfo.setPassword(source.getPassword());
    	employeeInfo.setEvaluation(source.getEvaluation());
    	employeeInfo.setRole(source.getRole());
    	employeeInfo.setSalary(source.getSalary());
    	employeeInfo.setScn(source.getScn());
    	
        return employeeInfo;
    }
}
