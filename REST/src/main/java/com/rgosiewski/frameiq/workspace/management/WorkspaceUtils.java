/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.workspace.management;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
class WorkspaceUtils {

    @Value("${workspace.path}")
    private String workspacePath;

    String getWorkspacePath() {
        return workspacePath;
    }

}
