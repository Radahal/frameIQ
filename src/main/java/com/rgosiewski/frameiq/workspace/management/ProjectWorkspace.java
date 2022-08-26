/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.management;

import com.rgosiewski.frameiq.workspace.enums.FileExtensions;
import com.rgosiewski.frameiq.workspace.exception.InvalidProjectPathException;
import com.rgosiewski.frameiq.workspace.exception.NewWorkspaceDirectoryException;
import com.rgosiewski.frameiq.workspace.exception.NewWorkspaceFileException;
import com.rgosiewski.frameiq.workspace.exception.NonExistingProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;

@Service
class ProjectWorkspace {
    private final WorkspaceUtils workspaceUtils;
    private final Logger logger = LogManager.getLogger(ProjectWorkspace.class);

    public ProjectWorkspace(WorkspaceUtils workspaceUtils) {
        this.workspaceUtils = workspaceUtils;
    }

    public void createProjectDir(String projectName) {
        logger.log(Level.INFO, "Creating new project: {}", projectName);
        File projectDir = getProjectDir(projectName);
        if (!projectDir.exists() && !projectDir.mkdir()) {
            throw new NewWorkspaceDirectoryException(projectName);
        }
        logger.log(Level.INFO, "Project created: {}", projectName);
    }

    public File getProjectDir(String projectName) {

        try {
            Path projectPath = getRepositoryRoot().toPath().resolve(projectName);
            return projectPath.toFile();
        } catch (Exception e) {
            throw new InvalidProjectPathException(projectName);
        }
    }

    private File getRepositoryRoot() {
        return new File(workspaceUtils.getWorkspacePath());
    }

    public void addFileToProject(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        logger.log(Level.INFO, "Creating new {} file: {} in the project: {}", extension, fileName, projectName);
        File projectDir = getProjectDir(projectName);
        if ( !projectDir.exists()) {
            throw new NonExistingProjectException(projectName);
        }
        File newFile = projectDir.toPath().resolve(fileName + "." + extension.getExtension()).toFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            fileOutputStream.write(fileContent);
        } catch (Exception e) {
            throw new NewWorkspaceFileException(fileName, extension, projectName);
        }
        logger.log(Level.INFO, "{} file created: {} in the project: {}", extension, fileName, projectName);
    }


}
