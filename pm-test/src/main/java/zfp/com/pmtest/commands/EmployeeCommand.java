package zfp.com.pmtest.commands;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zfp.com.pmtest.entity.EmployeeInfo;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.entity.Project;


	@Getter
	@Setter
	@NoArgsConstructor
	public class EmployeeCommand {
	    private int id;
	    private String firstName;
	    private String lastName;
	    private Date dob;
	    private String jobTitle;
	    private Date hiringDate;
	    private Date terminationDate;
	    private String email;
	    private String telephone;
	    private EmployeeInfoCommand empInfo;
	    private Employee manager;
	    Set<ProjectCommand> projects = new HashSet<>();
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		
		public String getJobTitle() {
			return jobTitle;
		}
		public void setJobTitle(String jobTitle) {
			this.jobTitle = jobTitle;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public Date getHiringDate() {
			return hiringDate;
		}
		public void setHiringDate(Date hiringDate) {
			this.hiringDate = hiringDate;
		}
		public Date getTerminationDate() {
			return terminationDate;
		}
		public void setTerminationDate(Date terminationDate) {
			this.terminationDate = terminationDate;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		
		public EmployeeInfoCommand getEmpInfo() {
			return empInfo;
		}
		public void setEmpInfo(EmployeeInfoCommand empInfo) {
			this.empInfo = empInfo;
		}
		public Employee getManager() {
			return manager;
		}
		public void setManager(Employee manager) {
			this.manager = manager;
		}
		public Set<ProjectCommand> getProjects() {
			return projects;
		}
		public void setProjects(Set<ProjectCommand> projects) {
			this.projects = projects;
		}
		
	}


