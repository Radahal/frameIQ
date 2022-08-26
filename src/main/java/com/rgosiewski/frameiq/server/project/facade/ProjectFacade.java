/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.facade;

import com.rgosiewski.frameiq.database.implementation.service.ProjectService;
import com.rgosiewski.frameiq.server.common.stereotype.Facade;
import com.rgosiewski.frameiq.server.project.dto.CreateProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.EditProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.ProjectDTO;
import com.rgosiewski.frameiq.server.project.populator.CreateProjectDataFromCreateProjectDTOPopulator;
import com.rgosiewski.frameiq.server.project.populator.EditProjectDataFromEditProjectDTOPopulator;
import com.rgosiewski.frameiq.server.project.populator.ProjectDTOFromProjectDataPopulator;

import java.util.List;

@Facade
public class ProjectFacade {
    private final ProjectService projectService;
    private final ProjectDTOFromProjectDataPopulator fromProjectDataPopulator;
    private final CreateProjectDataFromCreateProjectDTOPopulator fromCreateProjectDTOPopulator;
    private final EditProjectDataFromEditProjectDTOPopulator fromEditProjectDTOPopulator;

    public ProjectFacade(ProjectService projectService,
                         ProjectDTOFromProjectDataPopulator fromProjectDataPopulator, CreateProjectDataFromCreateProjectDTOPopulator fromCreateProjectDTOPopulator, EditProjectDataFromEditProjectDTOPopulator fromEditProjectDTOPopulator) {
        this.projectService = projectService;
        this.fromProjectDataPopulator = fromProjectDataPopulator;
        this.fromCreateProjectDTOPopulator = fromCreateProjectDTOPopulator;
        this.fromEditProjectDTOPopulator = fromEditProjectDTOPopulator;
    }

    public ProjectDTO getProjectByName(String projectName) {
        return fromProjectDataPopulator.populate(projectService.getProject(projectName));
    }

    public ProjectDTO getProject(Long projectId) {
        return fromProjectDataPopulator.populate(projectService.getProject(projectId));
    }

    public List<ProjectDTO> getProjects() {
        return fromProjectDataPopulator.populateAll(projectService.listProjects());
    }

    public ProjectDTO createProject(CreateProjectDTO createProjectDTO) {
       return fromProjectDataPopulator.populate(
               projectService.createProject(fromCreateProjectDTOPopulator.populate(createProjectDTO))
       );
    }

    public ProjectDTO editProject(Long projectId, EditProjectDTO editProjectDTO) {
        return fromProjectDataPopulator.populate(
                projectService.editProject(fromEditProjectDTOPopulator.populate(projectId, editProjectDTO))
        );
    }
}
