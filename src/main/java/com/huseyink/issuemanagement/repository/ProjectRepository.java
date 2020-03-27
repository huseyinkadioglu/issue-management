package com.huseyink.issuemanagement.repository;

import com.huseyink.issuemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> getAllByProjectCode (String projectCode);
}
