/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.project.controller;

import com.rgosiewski.frameiq.server.project.dto.CreateProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.EditProjectDTO;
import com.rgosiewski.frameiq.server.project.dto.ProjectDTO;
import com.rgosiewski.frameiq.server.project.facade.ProjectFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {
    private final Logger logger = LogManager.getLogger(ProjectController.class);
    private final ProjectFacade projectFacade;

    public ProjectController(ProjectFacade projectFacade) {
        this.projectFacade = projectFacade;
    }

    @GetMapping
    public List<ProjectDTO> getProjects() {
        return projectFacade.getProjects();
    }

    @PutMapping
    public ProjectDTO createProject(@RequestBody CreateProjectDTO createProjectDTO) {
        return projectFacade.createProject(createProjectDTO);
    }

    @PatchMapping("/{projectId}")
    public ProjectDTO editProject( @PathVariable Long projectId,
            @RequestBody EditProjectDTO editProjectDTO) {
        return projectFacade.editProject(projectId, editProjectDTO);
    }

//    @GetMapping("split")
//    public void splitVideo() {
//        String projectName = "shortVideo";
//        repository.createNewProject(projectName);
//        //baza danych - Project project = getProject(projectName) -(w tle getOrCreate)
//        Path projectPath = repository.getProjectPath(projectName);
//        // ExecutableConfiguration
//        //    -> splitVideo?
//        //      true -> videoPath?
//        //           -> fileExtension (jpeg, png)
//        //    -> projectName
//        //    -> treshold
//        //    -> metric
//        Path videoPath = Paths.get("D:\\mgr\\src\\test.mp4");
//        VideoSplitter videoSplitter = new VideoSplitter(videoPath, projectPath);
//        videoSplitter.run();
//    }
//
//    @GetMapping("processImages")
//    public void processImages() {
//        String projectName = "shortVideo";
//        Path projectPath = repository.getProjectPath(projectName);
//        frameReader.processFrames(projectPath, Metrics.FOCAL_MESURE_SCORE);
//    }
//
//    @PostMapping("project")
//    public void createProject(@RequestBody String projectName) {
//        repository.createNewProject(projectName);
//    }
//
//    @PostMapping("project/{projectName}/add-file")
//    public void addFile(@PathVariable String projectName,
//            @RequestBody String fileContent) {
//        repository.addProjectFile(fileContent.getBytes(StandardCharsets.UTF_8), "testFile", FileExtensions.TXT, projectName);
//    }

}
