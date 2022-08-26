/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.common.application.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.rgosiewski.frameiq.database.definition.repository")
@EntityScan(basePackages = "com.rgosiewski.frameiq.database.implementation.model")
public class PersistanceConfig {
}

