/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.management;

import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import com.rgosiewski.frameiq.repository.exception.NonExistingProjectException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class Repository {
    private final ProjectRepository projectRepository;
    private final RepositoryUtils repositoryUtils;

    public Repository(ProjectRepository projectRepository, RepositoryUtils repositoryUtils) {
        this.projectRepository = projectRepository;
        this.repositoryUtils = repositoryUtils;
    }

    public Path getRepositoryPath() {
        return Paths.get(repositoryUtils.getRepositoryPath());
    }

    public Path getProjectPath(String projectName) {
        Path projectPath = Paths.get(repositoryUtils.getRepositoryPath()).resolve(projectName);
        if(projectPath.toFile().exists()) {
            return projectPath;
        }
        throw new NonExistingProjectException(projectName);
    }

    public void createNewProject(String projectName) {
        projectRepository.createProjectDir(projectName);
    }

    public void addProjectFile(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        projectRepository.addFileToProject(fileContent, fileName, extension, projectName);
    }
}
