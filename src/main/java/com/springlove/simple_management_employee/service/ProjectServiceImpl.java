package com.springlove.simple_management_employee.service;

import com.springlove.simple_management_employee.dto.ProjectCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.ProjectPatchDTO;
import com.springlove.simple_management_employee.entity.Project;
import com.springlove.simple_management_employee.exception.business.DateTimeFormatException;
import com.springlove.simple_management_employee.exception.common.ResourceNotFoundException;
import com.springlove.simple_management_employee.repository.ProjectRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project findProjectByProjectId(Integer id) {
        return projectRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Project Not Found")
                );
    }

    @Override
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }


    @Override
    @Transactional
    public Project addNewProject(ProjectCreateUpdateDTO projectCreateUpdateDTO) {
        if (!isValidDateTimeFormat(
                projectCreateUpdateDTO.getStartDate(),
                projectCreateUpdateDTO.getEndDate())) {
            throw new DateTimeFormatException("Start Date must be before End Date");
        }

        Project project = new Project();

        project.setName(projectCreateUpdateDTO.getName());
        project.setStartDate(projectCreateUpdateDTO.getStartDate());
        project.setEndDate(projectCreateUpdateDTO.getEndDate());
        project.setStatus(projectCreateUpdateDTO.getStatus());

        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project updateProjectByProjectId(Integer id, ProjectCreateUpdateDTO projectCreateUpdateDTO) {
        if (!isValidDateTimeFormat(
                projectCreateUpdateDTO.getStartDate(),
                projectCreateUpdateDTO.getEndDate())) {
            throw new DateTimeFormatException("Start Date must be before End Date");
        }

        Project project = findProjectByProjectId(id);

        project.setName(projectCreateUpdateDTO.getName());
        project.setStartDate(projectCreateUpdateDTO.getStartDate());
        project.setEndDate(projectCreateUpdateDTO.getEndDate());
        project.setStatus(projectCreateUpdateDTO.getStatus());

        return projectRepository.save(project);
    }

    @Override
    public boolean isValidDateTimeFormat(LocalDateTime startDate, LocalDateTime endDate) {
        return startDate.isBefore(endDate);
    }

    @Override
    @Transactional
    public Project updatePartialProjectByProjectId(Integer id, ProjectPatchDTO projectPatchDTO) {
        if (projectPatchDTO.getStartDate() != null && projectPatchDTO.getEndDate() != null) {
            if (!isValidDateTimeFormat(
                    projectPatchDTO.getStartDate(),
                    projectPatchDTO.getEndDate())) {
                throw new DateTimeFormatException("Start Date must be before End Date");
            }
        }

        Project project = findProjectByProjectId(id);

        if (projectPatchDTO.getName() != null) {
            project.setName(projectPatchDTO.getName());
        }

        if (projectPatchDTO.getStartDate() != null) {
            project.setStartDate(projectPatchDTO.getStartDate());
        }

        if (projectPatchDTO.getEndDate() != null) {
            project.setEndDate(projectPatchDTO.getEndDate());
        }

        if (projectPatchDTO.getStatus() != null) {
            project.setStatus(projectPatchDTO.getStatus());
        }

        return projectRepository.save(project);
    }

    @Override
    public Page<Project> findAllAndPagination(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
}
