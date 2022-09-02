/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.server.processing.exception;

import com.rgosiewski.frameiq.server.processing.data.ProcessingData;

public class ProcessingException extends RuntimeException {

    public ProcessingException(ProcessingData processingData, Throwable cause) {
        super("Processing with id: %d is aborted due to error", cause);
    }


}
