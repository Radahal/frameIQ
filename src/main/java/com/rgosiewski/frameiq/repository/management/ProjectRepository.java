/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.management;

import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import com.rgosiewski.frameiq.repository.exception.InvalidProjectPathException;
import com.rgosiewski.frameiq.repository.exception.NewRepositoryDirectoryException;
import com.rgosiewski.frameiq.repository.exception.NewRepositoryFileException;
import com.rgosiewski.frameiq.repository.exception.NonExistingProjectException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;

@Service
class ProjectRepository {
    private final RepositoryUtils repositoryUtils;
    private final Logger logger = LogManager.getLogger(ProjectRepository.class);

    public ProjectRepository(RepositoryUtils repositoryUtils) {
        this.repositoryUtils = repositoryUtils;
    }

    public void createProjectDir(String projectName) {
        logger.log(Level.INFO, "Creating new project: {}", projectName);
        File projectDir = getProjectDir(projectName);
        if (!projectDir.exists() && !projectDir.mkdir()) {
            throw new NewRepositoryDirectoryException(projectName);
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
        return new File(repositoryUtils.getRepositoryPath());
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
            throw new NewRepositoryFileException(fileName, extension, projectName);
        }
        logger.log(Level.INFO, "{} file created: {} in the project: {}", extension, fileName, projectName);
    }


}
