package com.rgosiewski.frameiq.database.definition.service;

import com.rgosiewski.frameiq.server.project.data.CreateProjectData;
import com.rgosiewski.frameiq.server.project.data.EditProjectData;
import com.rgosiewski.frameiq.server.project.data.ProjectData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectService {
    public List<ProjectData> listProjects();

    public ProjectData getProject(Long projectId);

    public ProjectData getProject(String projectName);

    public ProjectData createProject(CreateProjectData createProjectData);

    public ProjectData editProject(EditProjectData editProjectData);
}
