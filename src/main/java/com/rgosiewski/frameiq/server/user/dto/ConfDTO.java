///*
// * Copyright © 2022 Rafał Gosiewski
// * All rights reserved
// */
//
//package com.rgosiewski.frameiq.server.user.dto;
//
//import com.rgosiewski.frameiq.alghorithm.enums.Metrics;
//import com.rgosiewski.frameiq.repository.enums.FileExtensions;
//
//public class BlueprintDTO {
//    private final boolean splitVideo;
//    private final String videoPath;
//    private final FileExtensions fileExtension;
//    private final String projectName;
//    private final double treshold;
//    private final Metrics metric;
//
//    public BlueprintDTO(boolean splitVideo, String videoPath, FileExtensions fileExtension, String projectName, double treshold, Metrics metric) {
//        this.splitVideo = splitVideo;
//        this.videoPath = videoPath;
//        this.fileExtension = fileExtension;
//        this.projectName = projectName;
//        this.treshold = treshold;
//        this.metric = metric;
//    }
//
//    public boolean isSplitVideo() {
//        return splitVideo;
//    }
//
//    public String getVideoPath() {
//        return videoPath;
//    }
//
//    public FileExtensions getFileExtension() {
//        return fileExtension;
//    }
//
//    public String getProjectName() {
//        return projectName;
//    }
//
//    public double getTreshold() {
//        return treshold;
//    }
//
//    public Metrics getMetric() {
//        return metric;
//    }
//
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//        private boolean splitVideo;
//        private String videoPath;
//        private FileExtensions fileExtension;
//        private String projectName;
//        private double treshold;
//        private Metrics metric;
//
//        public Builder withSplitVideo(boolean splitVideo) {
//            this.splitVideo = splitVideo;
//            return this;
//        }
//
//        public Builder withVideoPath(String videoPath) {
//            this.videoPath = videoPath;
//            return this;
//        }
//
//        public Builder withFileExtension(FileExtensions fileExtension) {
//            this.fileExtension = fileExtension;
//            return this;
//        }
//
//        public Builder withProjectName(String projectName) {
//            this.projectName = projectName;
//            return this;
//        }
//
//        public Builder withTreshold(double treshold) {
//            this.treshold = treshold;
//            return this;
//        }
//
//        public Builder withMetric(Metrics metric) {
//            this.metric = metric;
//            return this;
//        }
//
//        public BlueprintDTO build() {
//            return new BlueprintDTO(splitVideo, videoPath, fileExtension, projectName, treshold, metric);
//        }
//    }
//}
