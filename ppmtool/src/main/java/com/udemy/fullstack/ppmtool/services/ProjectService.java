package com.udemy.fullstack.ppmtool.services;

import com.udemy.fullstack.ppmtool.domain.Project;
import com.udemy.fullstack.ppmtool.exceptions.ProjectIdExceptions;
import com.udemy.fullstack.ppmtool.repository.ProjectRepository;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project)
    {
         try {

             project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());

             return projectRepository.save(project);

         } catch(Exception e)
        {
            throw new ProjectIdExceptions("Project ID '" +project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

}
