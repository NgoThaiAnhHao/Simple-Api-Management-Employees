package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.ProjectCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.ProjectPatchDTO;
import com.springlove.simple_management_employee.entity.Project;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ProjectService {
    Project findProjectByProjectId(Integer id);

    List<Project> findAllProject();

    Project addNewProject(ProjectCreateUpdateDTO projectCreateUpdateDTO);

    Project updateProjectByProjectId(Integer id, ProjectCreateUpdateDTO projectCreateUpdateDTO);

    boolean isValidDateTimeFormat(LocalDateTime startDate, LocalDateTime endDate);

    Project updatePartialProjectByProjectId(Integer id, ProjectPatchDTO projectPatchDTO);

    Page<Project> findAllAndPagination(Pageable pageable);
}
