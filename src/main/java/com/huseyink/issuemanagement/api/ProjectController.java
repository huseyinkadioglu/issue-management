package com.huseyink.issuemanagement.api;

import com.huseyink.issuemanagement.dto.ProjectDto;
import com.huseyink.issuemanagement.service.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( "/projects" )
public class ProjectController {


    private ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    // GetMapping ve PathVariable'ın kullanımı.

    @GetMapping( "/apitest" )
    public String test() {
        return "this is a test";
    }


    @GetMapping( "/{id}" )
    public ResponseEntity<ProjectDto> getById(@PathVariable( "id" ) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }


    @PostMapping()
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(projectServiceImpl.save(projectDto));

    }


}
