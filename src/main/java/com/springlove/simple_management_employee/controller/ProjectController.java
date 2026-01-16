package com.springlove.simple_management_employee.controller;

import com.springlove.simple_management_employee.dto.ProjectCreateUpdateDTO;
import com.springlove.simple_management_employee.dto.ProjectPatchDTO;
import com.springlove.simple_management_employee.entity.Project;
import com.springlove.simple_management_employee.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    // GET /api/projects/{id}
    @GetMapping("/projects/{id}")
    public Project findProjectByProjectId (
            @PathVariable Integer id) {
        return projectService.findProjectByProjectId(id);
    }

    // GET /api/projects
    /* @GetMapping("/projects")
    public List<Project> findAllProject() {
        return projectService.findAllProject();
    } */

    // POST /api/projects
    @PostMapping("/projects")
    public Project addNewProject(
            @Valid @RequestBody ProjectCreateUpdateDTO projectCreateUpdateDTO) {
        return projectService.addNewProject(projectCreateUpdateDTO);
    }

    // PUT /api/projects/{id}
    @PutMapping("/projects/{id}")
    public Project updateProjectByProjectId(
            @PathVariable Integer id,
            @Valid @RequestBody ProjectCreateUpdateDTO projectCreateUpdateDTO) {
        return projectService.updateProjectByProjectId(id, projectCreateUpdateDTO);
    }

    // PATCH /api/projects/{id}
    @PatchMapping("/projects/{id}")
    public Project updatePartialProjectByProjectId(
            @PathVariable Integer id,
            @Valid @RequestBody ProjectPatchDTO projectPatchDTO) {
        return projectService.updatePartialProjectByProjectId(id, projectPatchDTO);
    }

    // Pagination
    // GET /api/projects
    @GetMapping("/projects")
    public Page<Project> findAllProjectsAndPagination(Pageable pageable) {
        return projectService.findAllAndPagination(pageable);
    }

}
