package zfp.com.pmtest.dao;

import org.springframework.data.repository.CrudRepository;

import zfp.com.pmtest.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
	

}
