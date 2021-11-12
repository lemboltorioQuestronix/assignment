package com.jrp.pma.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;
import com.jrp.pma.services.ProjectService;

@RestController
@RequestMapping("/test-api/projects")
public class TestController {

	@Autowired
	ProjectRepository projRepo;
	
	@Autowired
	ProjectService projService;
	
	@GetMapping
	public Iterable<Project> getProjects(){
		return projRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Project getProjectById(@PathVariable("id") Long id){
		return projRepo.findById(id).get();
	}
	
	@PostMapping("/newProject")
	public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
		
		Project newProject = projService.createProject(project);
		
		return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
		
	}
	
	@PatchMapping(path = "/updateProject/{id}")
	public ResponseEntity<Project> updateProject(@PathVariable("id") long id, @Valid @RequestBody Project project) {
		
		Project updatedProject = projService.updateProject(id, project);
		
		return new ResponseEntity<Project>(updatedProject, HttpStatus.CREATED);
		
	}
	
}
