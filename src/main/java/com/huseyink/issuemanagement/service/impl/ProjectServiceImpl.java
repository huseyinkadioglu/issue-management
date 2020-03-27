package com.huseyink.issuemanagement.service.impl;

import com.huseyink.issuemanagement.entity.Project;
import com.huseyink.issuemanagement.repository.ProjectRepository;
import com.huseyink.issuemanagement.service.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {


    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {


        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null!");
        }

        return this.projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return this.projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(Project project) {
        return null;
    }
}
