/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.management;

import com.rgosiewski.frameiq.workspace.enums.FileExtensions;
import com.rgosiewski.frameiq.workspace.exception.NonExistingProjectException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Workspace {
    private final ProjectWorkspace projectWorkspace;
    private final WorkspaceUtils workspaceUtils;

    public Workspace(ProjectWorkspace projectWorkspace, WorkspaceUtils workspaceUtils) {
        this.projectWorkspace = projectWorkspace;
        this.workspaceUtils = workspaceUtils;
    }

    public Path getWorkspacePath() {
        return Paths.get(workspaceUtils.getWorkspacePath());
    }

    public Path getProjectPath(String projectName) {
        Path projectPath = Paths.get(workspaceUtils.getWorkspacePath()).resolve(projectName);
        if(projectPath.toFile().exists()) {
            return projectPath;
        }
        throw new NonExistingProjectException(projectName);
    }

    public void createNewProject(String projectName) {
        projectWorkspace.createProjectDir(projectName);
    }

    public void addProjectFile(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        projectWorkspace.addFileToProject(fileContent, fileName, extension, projectName);
    }
}
