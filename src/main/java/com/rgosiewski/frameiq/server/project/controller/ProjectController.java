/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.controller;

import com.rgosiewski.frameiq.server.project.dto.CreateProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.EditProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.ProjectDTO;
import com.rgosiewski.frameiq.server.project.facade.ProjectFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
    private final Logger logger = LogManager.getLogger(ProjectController.class);
    private final ProjectFacade projectFacade;

    public ProjectController(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    @GetMapping
    public List<ProjectDTO> getProjects() {
        return projectFacade.getProjects();
    }

    @GetMapping("/{projectId}")
    public ProjectDTO getProject(@PathVariable Long projectId) {
        return projectFacade.getProject(projectId);
    }

    @PutMapping
    public ProjectDTO createProject(@RequestBody @Validated CreateProjectDTO createProjectDTO) {
        return projectFacade.createProject(createProjectDTO);
    }

    @PatchMapping("/{projectId}")
    public ProjectDTO editProject( @PathVariable Long projectId,
            @RequestBody @Validated EditProjectDTO editProjectDTO) {
        return projectFacade.editProject(projectId, editProjectDTO);
    }
}
