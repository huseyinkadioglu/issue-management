package com.huseyink.issuemanagement.service;

import com.huseyink.issuemanagement.dto.ProjectDto;
import com.huseyink.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto project);

    ProjectDto getById(Long id);

    List<ProjectDto> getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    Page<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto project);
}
