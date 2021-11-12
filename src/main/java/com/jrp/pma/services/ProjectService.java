package com.jrp.pma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projRepo;
	
	public Project createProject(Project project) {
		
		return projRepo.save(project);
		
	}
	
	public Project updateProject(long projectId, Project project) {
		
		Project projectObj = projRepo.findByProjectId(projectId);
		
		if(null != project.getName()) {
			projectObj.setName(project.getName());
		}
		
		if(null != project.getStage()) {
			projectObj.setStage(project.getStage());
		}
		
		if(null != project.getDescription()) {
			projectObj.setDescription(project.getDescription());
		}
		
		return projRepo.save(project);
		
	}
	
}
