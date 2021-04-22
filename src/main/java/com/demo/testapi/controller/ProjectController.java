package com.demo.testapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.testapi.constant.ServiceConstant;
import com.demo.testapi.exception.RecordNotFoundException;
import com.demo.testapi.model.ProjectDetails;
import com.demo.testapi.service.ProjectService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/proj")
public class ProjectController {

	@Autowired
	ProjectService ser;

	@ApiOperation(value = "RetrieveProjectDetails", tags = "Get Project by id", notes = ServiceConstant.GET_IMPLEMENTATION_NOTES)
	@GetMapping(value = "/projdetails/{id}")
	public ResponseEntity<ProjectDetails> getAllProjects(@PathVariable int id) {

		ProjectDetails projDetails = ser.getProjByID(id);
		if (projDetails != null)
			return new ResponseEntity<>(projDetails, HttpStatus.OK);
		else
			throw new RecordNotFoundException("No Project Found for ID : " + id);

	}

	@ApiOperation(value = "AddProjectDetails", tags = "Add New Projects", notes = ServiceConstant.POST_IMPLEMENTATION_NOTES, response = ProjectDetails.class)
	@PostMapping(value = "/addprojdetails", headers = "Accept=application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProjectDetails> addNewProject(@RequestBody ProjectDetails projDetails) {
		try {
			ProjectDetails projDetails1 = ser
					.save(new ProjectDetails(projDetails.getProjectName(), projDetails.getProjectDescription()));
			return new ResponseEntity<>(projDetails1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
