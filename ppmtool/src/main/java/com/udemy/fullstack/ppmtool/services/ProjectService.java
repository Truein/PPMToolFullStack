package com.udemy.fullstack.ppmtool.services;

import com.udemy.fullstack.ppmtool.domain.Project;
import com.udemy.fullstack.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project)
    {

        return projectRepository.save(project);

    }

}
