package com.rgosiewski.frameiq.database.implementation.service;

import com.rgosiewski.frameiq.database.definition.repository.ProjectRepository;
import com.rgosiewski.frameiq.database.definition.service.IProjectService;
import com.rgosiewski.frameiq.database.implementation.model.ProjectEntity;
import com.rgosiewski.frameiq.server.project.data.CreateProjectData;
import com.rgosiewski.frameiq.server.project.data.EditProjectData;
import com.rgosiewski.frameiq.server.project.data.ProjectData;
import com.rgosiewski.frameiq.server.project.populator.ProjectDataFromProjectEntityPopulator;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;
    private final UserService userService;
    private final ProjectDataFromProjectEntityPopulator fromProjectEntityPopulator;

    public ProjectService(ProjectRepository projectRepository,
                          UserService userService, ProjectDataFromProjectEntityPopulator fromProjectEntityPopulator) {
        this.projectRepository = projectRepository;
        this.userService = userService;
        this.fromProjectEntityPopulator = fromProjectEntityPopulator;
    }

    @Override
    public ProjectData getProject(Long projectId) {
        return fromProjectEntityPopulator.populate(projectRepository.getById(projectId));
    }

    @Override
    public ProjectData getProject(String projectName) {
        return fromProjectEntityPopulator.populate(projectRepository.findByName(projectName));
    }

    @Override
    public List<ProjectData> listProjects() {
        return fromProjectEntityPopulator.populateAll(projectRepository.findAll());
    }

    @Override
    public ProjectData createProject(CreateProjectData createProjectData) {
        ProjectEntity entity = new ProjectEntity();
        entity.setName(createProjectData.getName());
        entity.setDescription(createProjectData.getDescription());
        entity.setCreationTime(new Date());
        entity.setModificationTime(new Date());
        entity.setCreationUsId(userService.getAdminId());
        entity.setModificationUsId(userService.getAdminId());
        return fromProjectEntityPopulator.populate(projectRepository.saveAndFlush(entity));
    }

    @Override
    public ProjectData editProject(EditProjectData editProjectData) {
        ProjectEntity entity = projectRepository.getById(editProjectData.getId());
        entity.setName(editProjectData.getName());
        entity.setDescription(editProjectData.getDescription());
        entity.setModificationTime(new Date());
        entity.setModificationUsId(userService.getAdminId());
        return fromProjectEntityPopulator.populate(projectRepository.saveAndFlush(entity));
    }
}
