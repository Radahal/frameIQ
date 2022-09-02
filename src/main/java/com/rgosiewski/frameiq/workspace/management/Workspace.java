/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.management;

import com.rgosiewski.frameiq.workspace.enums.FileExtensions;
import com.rgosiewski.frameiq.workspace.exception.NonExistingProjectException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public Path getOrCreateProjectPath(String projectName) {
        Path projectPath = Paths.get(workspaceUtils.getWorkspacePath()).resolve(projectName);
        if( !projectPath.toFile().exists()) {
            projectPath.toFile().mkdir();
        }
        return projectPath;
    }

    public Path getProjectPath(String projectName) {
        Path projectPath = Paths.get(workspaceUtils.getWorkspacePath()).resolve(projectName);
        if(projectPath.toFile().exists()) {
            return projectPath;
        }
        throw new NonExistingProjectException(projectName);
    }

    public List<File> listProjectFiles(String projectName) {
        Path projectPath = getProjectPath(projectName);
        File[] files = projectPath.toFile().listFiles();
        if (files == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(files);
    }

    public List<File> listProjectFilesByFileExtension(String projectName, FileExtensions fileExtension) {
        Path projectPath = getProjectPath(projectName);
        File[] files = projectPath.toFile().listFiles();
        if (files == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(files)
                .filter(f -> f.getName().endsWith(fileExtension.getExtension()))
                .collect(Collectors.toList());
    }

    public void createNewProject(String projectName) {
        projectWorkspace.createProjectDir(projectName);
    }

    public void addProjectFile(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        projectWorkspace.addFileToProject(fileContent, fileName, extension, projectName);
    }
}
