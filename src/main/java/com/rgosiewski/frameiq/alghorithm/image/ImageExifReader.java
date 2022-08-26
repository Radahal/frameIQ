/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.exception.ImageExifReaderException;
import com.rgosiewski.frameiq.alghorithm.model.ExifMetadata;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageExifReader {
    private final Logger logger = LogManager.getLogger(ImageExifReader.class);

    public Optional<ExifMetadata> getExifMetadata(File imageFile) {
        try {
            final ImageMetadata metadata = Imaging.getMetadata(imageFile);
            if (metadata == null ) {
                return Optional.empty();
            }
            logger.info("Exif metadata for file {}: {}", imageFile.toPath(), metadata);
            return Optional.of(ExifMetadata.builder()
                    .withMetadata(metadata.toString())
                    .build());
        } catch (ImageReadException | IOException e) {
            throw new ImageExifReaderException(imageFile.toPath());
        }
    }
}
