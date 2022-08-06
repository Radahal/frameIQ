/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.management;

import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import com.rgosiewski.frameiq.repository.exception.NewRepositoryDirectoryException;
import com.rgosiewski.frameiq.repository.exception.NewRepositoryFileException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;

@Service
class ProjectRepository {
    private final RepositoryUtils repositoryUtils;
    private final Logger logger = LogManager.getLogger(ProjectRepository.class);

    public ProjectRepository(RepositoryUtils repositoryUtils) {
        this.repositoryUtils = repositoryUtils;
    }

    public void createProjectDir(String projectName) {
        logger.log(Level.INFO, "Creating new project: {}", projectName);
        File projectDir;
        try {
            projectDir = getProjectDir(projectName);
        } catch (Exception e) {
            throw new NewRepositoryDirectoryException(projectName);
        }
        if (!projectDir.mkdir()) {
            throw new NewRepositoryDirectoryException(projectName);
        }
        logger.log(Level.INFO, "Project created: {}", projectName);
    }

    public File getProjectDir(String projectName) {
        return getRepositoryRoot().toPath().resolve(projectName).toFile();
    }

    private File getRepositoryRoot() {
        return new File(repositoryUtils.getRepositoryPath());
    }

    public void addFileToProject(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        logger.log(Level.INFO, "Creating new {} file: {} in the project: {}", extension, fileName, projectName);
        File projectDir = getProjectDir(projectName);
        File newFile = projectDir.toPath().resolve(fileName + "." + extension.getExtension()).toFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {
            fileOutputStream.write(fileContent);
        } catch (Exception e) {
            throw new NewRepositoryFileException(fileName, extension, projectName);
        }
        logger.log(Level.INFO, "{} file created: {} in the project: {}", extension, fileName, projectName);
    }


}
