/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.user.controller;

import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
import com.rgosiewski.frameiq.alghorithm.image.FrameReader;
import com.rgosiewski.frameiq.alghorithm.video.VideoSplitter;
import com.rgosiewski.frameiq.repository.enums.FileExtensions;
import com.rgosiewski.frameiq.repository.management.Repository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("users/")
public class UserController {
    private final Repository repository;
    private final FrameReader frameReader;
    private final Logger logger = LogManager.getLogger(UserController.class);

    public UserController(Repository repository, FrameReader frameReader) {
        this.repository = repository;
        this.frameReader = frameReader;
    }

    @GetMapping
    public void getUser() {
        logger.log(Level.INFO, "Request get user");
    }

    @GetMapping("split")
    public void splitVideo() {
        String projectName = "shortVideo";
        repository.createNewProject(projectName);
        Path projectPath = repository.getProjectPath(projectName);
        Path videoPath = Paths.get("D:\\mgr\\src\\test.mp4");
        VideoSplitter videoSplitter = new VideoSplitter(videoPath, projectPath);
        videoSplitter.run();
    }

    @GetMapping("processImages")
    public void processImages() {
        String projectName = "splitVideo";
        Path projectPath = repository.getProjectPath(projectName);
        frameReader.processFrames(projectPath, Metrics.FAST_FOURIER_TRANSFORM_SCORE);
    }

    @PostMapping("project")
    public void createProject(@RequestBody String projectName) {
        repository.createNewProject(projectName);
    }

    @PostMapping("project/{projectName}/add-file")
    public void addFile(@PathVariable String projectName,
            @RequestBody String fileContent) {
        repository.addProjectFile(fileContent.getBytes(StandardCharsets.UTF_8), "testFile", FileExtensions.TXT, projectName);
    }
}
