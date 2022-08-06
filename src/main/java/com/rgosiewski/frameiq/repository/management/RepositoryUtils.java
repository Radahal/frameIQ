/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class RepositoryUtils {

    @Value("${repository.path}")
    private String repositoryPath;

    String getRepositoryPath() {
        return repositoryPath;
    }

}
