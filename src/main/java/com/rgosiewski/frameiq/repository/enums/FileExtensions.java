/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.repository.enums;

import com.rgosiewski.frameiq.server.common.exception.IllegalEnumValueException;

import java.util.Arrays;

public enum FileExtensions {
    AVI("avi"),
    JPEG("jpeg"),
    PNG("png"),
    TXT("txt");


    private final String extension;

    FileExtensions(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public static FileExtensions getByExtension(String extension) {
        return Arrays.stream(values())
                .filter(f -> f.getExtension().equals(extension))
                .findFirst()
                .orElseThrow(IllegalEnumValueException::new);
    }
}
