package zfp.com.pmtest.commands;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zfp.com.pmtest.entity.Employee;

	
	public class ProjectCommand {
		private int id;

		private String projectType;
		
		private String name;
		
		private String description;
		
		private Date startDate;
		
		private Date endDate;
		
		private Float cost;
		
		private Set<EmployeeCommand> employees = new HashSet<>();

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getProjectType() {
			return projectType;
		}

		public void setProjectType(String projectType) {
			this.projectType = projectType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Float getCost() {
			return cost;
		}

		public void setCost(Float cost) {
			this.cost = cost;
		}

		public Set<EmployeeCommand> getEmployees() {
			return employees;
		}

		public void setEmployees(Set<EmployeeCommand> employees) {
			this.employees = employees;
		}

		

		
		
		
		


}
