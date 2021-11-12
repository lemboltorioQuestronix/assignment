package com.jrp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrp.pma.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Override
	public List<Project> findAll();
	public Project findByProjectId (long id);
	
}
