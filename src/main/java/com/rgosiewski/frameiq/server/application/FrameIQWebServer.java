/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameIQWebServer {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FrameIQWebServer.class);
        application.run(args);
    }
}
