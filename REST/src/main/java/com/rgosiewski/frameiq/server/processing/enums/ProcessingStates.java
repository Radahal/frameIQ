/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.enums;

import com.rgosiewski.frameiq.server.common.exception.IllegalEnumValueException;

import java.util.Arrays;

public enum ProcessingStates {
    QUEUED,
    STARTED,
    ABORTED,
    FINISHED;

    public static ProcessingStates fromName(String name) {
        return Arrays.stream(ProcessingStates.values())
                .filter(f -> f.name().equals(name))
                .findFirst()
                .orElseThrow(IllegalEnumValueException::new);
    }
}
