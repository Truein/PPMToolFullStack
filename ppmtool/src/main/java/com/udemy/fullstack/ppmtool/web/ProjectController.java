package com.udemy.fullstack.ppmtool.web;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.udemy.fullstack.ppmtool.domain.Project;
import com.udemy.fullstack.ppmtool.services.MapValidationErrorService;
import com.udemy.fullstack.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result)

    {

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) return errorMap;

        Project project1 = projectService.saveOrUpdateProject(project);

        return  new ResponseEntity<Project>(project, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId)
    {
        Project project = projectService.findProjectByIdentifier(projectId);


//        System.out.println("project = [" + project.toString() + "]");

        return new ResponseEntity<Project>(project, HttpStatus.OK);

    }

    @GetMapping("/all")
    public Iterable<Project> getAllProject()
    {
        return projectService.findAllProjects();

    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId)
    {
        projectService.deleteProjectByIdentifier(projectId);

        return new ResponseEntity<String>("Project with '" +projectId +"' was deleted", HttpStatus.OK);
    }
}
