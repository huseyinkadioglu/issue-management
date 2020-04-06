package com.huseyink.issuemanagement.api;

import com.huseyink.issuemanagement.dto.IssueDto;
import com.huseyink.issuemanagement.dto.ProjectDto;
import com.huseyink.issuemanagement.service.impl.IssueServiceImpl;
import com.huseyink.issuemanagement.util.ApiPaths;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping( ApiPaths.IssueCtrl.CTRL )
public class IssueController {

    private IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping( "/apitest" )
    public String test() {
        return "this is a test";
    }


    @GetMapping( "/{id}" )
    @ApiOperation( value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable( "id" ) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping()
    @ApiOperation( value = "Create Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping( "/{id}" )
    @ApiOperation( value = "Update Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable( "id" ) Long id, @Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @DeleteMapping( "/{id}" )
    @ApiOperation( value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable( "id" ) Long id) {
        return ResponseEntity.ok((issueServiceImpl.delete(id)));
    }


}
