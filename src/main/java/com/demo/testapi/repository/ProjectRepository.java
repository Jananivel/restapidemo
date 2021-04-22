package com.demo.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.testapi.model.ProjectDetails;

public interface ProjectRepository extends JpaRepository<ProjectDetails, Integer>{
	
	ProjectDetails findByProjectID(int id);
	
	

}
