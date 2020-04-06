package com.huseyink.issuemanagement.api;

import com.huseyink.issuemanagement.dto.ProjectDto;
import com.huseyink.issuemanagement.service.impl.ProjectServiceImpl;
import com.huseyink.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( ApiPaths.ProjectCtrl.CTRL )
@Api( value = "Project APIs" )
public class ProjectController {


    private ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }

    // GetMapping ve PathVariable'ın kullanımı.

    @GetMapping( "/apitest" )
    @ApiOperation( value = "test", response = String.class)
    public String test() {
        return "this is a test";
    }


    @GetMapping( "/{id}" )
    @ApiOperation( value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable( "id" ) Long id) {
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);

    }


    @PostMapping()
    @ApiOperation( value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    // PUT
    @PutMapping( "/{id}" )
    @ApiOperation( value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable( "id" ) Long id, @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping( "/{id}" )
    @ApiOperation( value = "Delete Operation", response = ProjectDto.class)
    public ResponseEntity<Boolean> delete(@PathVariable( "id" ) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }


}
