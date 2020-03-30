package com.huseyink.issuemanagement.service.impl;

import com.huseyink.issuemanagement.dto.ProjectDto;
import com.huseyink.issuemanagement.entity.Project;
import com.huseyink.issuemanagement.repository.ProjectRepository;
import com.huseyink.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectRepository projectRepository;
    private ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository,
                              ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

    Project p = modelMapper.map(projectDto,Project.class);
    p = projectRepository.save(p);
    projectDto.setId(p.getId());
    return projectDto;
    }


    @Override
    public ProjectDto getById(Long id) {
        Project p = this.projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);

    }

    @Override
    public List<ProjectDto> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }



    @Override
    public Boolean delete(ProjectDto project) {
        return null;
    }
}
