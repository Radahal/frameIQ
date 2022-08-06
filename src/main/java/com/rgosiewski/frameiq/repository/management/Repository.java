/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.management;

import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import org.springframework.stereotype.Service;

@Service
public class Repository {
    private final ProjectRepository projectRepository;
    private final RepositoryUtils repositoryUtils;

    public Repository(ProjectRepository projectRepository, RepositoryUtils repositoryUtils) {
        this.projectRepository = projectRepository;
        this.repositoryUtils = repositoryUtils;
    }

    public String getRepositoryPath() {
        return repositoryUtils.getRepositoryPath();
    }

    public void createNewProject(String projectName) {
        projectRepository.createProjectDir(projectName);
    }

    public void addProjectFile(byte[] fileContent, String fileName, FileExtensions extension, String projectName) {
        projectRepository.addFileToProject(fileContent, fileName, extension, projectName);
    }
}
