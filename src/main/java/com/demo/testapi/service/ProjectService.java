package com.demo.testapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.testapi.model.ProjectDetails;
import com.demo.testapi.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService {
	
	@Autowired
	ProjectRepository projRepository;
	
	public List<ProjectDetails> getAll() {
		return projRepository.findAll();
	}
	
	public ProjectDetails getProjByID(int id) {
		return projRepository.findByProjectID(id);
	}

	public ProjectDetails save(ProjectDetails projectDetails) {
		// TODO Auto-generated method stub
		return projRepository.save(projectDetails);
	}

}
