/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.image;

import com.rgosiewski.frameiq.alghorithm.exception.NonExistingFileException;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithm;
import com.rgosiewski.frameiq.alghorithm.metric.ImageProcessingAlgorithmFactory;
import com.rgosiewski.frameiq.alghorithm.model.ExifMetadata;
import com.rgosiewski.frameiq.alghorithm.model.FrameProcessedMetadata;
import com.rgosiewski.frameiq.database.implementation.service.ExifMetadataService;
import com.rgosiewski.frameiq.database.implementation.service.FrameMetadataService;
import com.rgosiewski.frameiq.database.implementation.service.FrameService;
import com.rgosiewski.frameiq.server.configuration.data.AlgorithmPropertiesData;
import com.rgosiewski.frameiq.server.frame.data.CreateFrameData;
import com.rgosiewski.frameiq.server.frame.data.FrameData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.CreateExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.data.ExifMetadataData;
import com.rgosiewski.frameiq.server.metadata.exifMetadata.enums.MetadataTypes;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.CreateFrameMetadataData;
import com.rgosiewski.frameiq.server.metadata.frameMetadata.data.FrameMetadataData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Optional;

public class ImageProcessor implements Runnable {
    private final static String DEFAULT_FRAME_DESCRIPTION = "Frame %s extracted from movie with id %d for IQ assessment by strategy %s.";
    private final Logger logger = LogManager.getLogger(ImageProcessor.class);
    private final FrameService frameService;
    private final FrameMetadataService frameMetadataService;
    private final ExifMetadataService exifMetadataService;
    private final ImageExifReader imageExifReader;
    private final Long movieId;
    private final Long processingId;
    private final File image;
    private final AlgorithmPropertiesData algorithmProperties;

    public ImageProcessor(FrameService frameService,
                          FrameMetadataService frameMetadataService,
                          ExifMetadataService exifMetadataService,
                          ImageExifReader imageExifReader,
                          Long movieId,
                          Long processingId,
                          File image,
                          AlgorithmPropertiesData algorithmProperties) {
        this.frameService = frameService;
        this.frameMetadataService = frameMetadataService;
        this.exifMetadataService = exifMetadataService;
        this.imageExifReader = imageExifReader;
        this.movieId = movieId;
        this.processingId = processingId;
        this.image = image;
        this.algorithmProperties = algorithmProperties;
    }

    @Override
    public void run() {
        if (image.exists()) {
            ImageProcessingAlgorithm processingAlgorithm = ImageProcessingAlgorithmFactory.getImageProcessingAlgorithm(algorithmProperties.getMetric());
            double metricValue = processingAlgorithm.calculateMetric(image.toPath());

            FrameData frameData = storeFrame();
            ExifMetadataData exifMetadataData = storeExifMetadata();
            storeFrameMetadata(frameData.getId(), exifMetadataData.getId(), metricValue);

            if (metricValue < algorithmProperties.getTreshold()) {
                logger.warn("Image {} is blurry with metric: {}", image.getName(), metricValue);
            }
            logger.info("Image {} processed: {}", image.getName(), metricValue);
        } else {
            throw new NonExistingFileException(image.toPath());
        }
    }

    private FrameData storeFrame() {
        String imageFilename = image.toPath().getFileName().toString();
        return frameService.createFrame(CreateFrameData.builder()
                .withOrdinal(Integer.valueOf(imageFilename.substring(0, imageFilename.lastIndexOf('.'))))
                .withMovieId(movieId)
                .withProcessingId(processingId)
                .withName(imageFilename)
                .withDescription(String.format(DEFAULT_FRAME_DESCRIPTION, imageFilename, movieId, algorithmProperties.getMetric()))
                .build());
    }

    private ExifMetadataData storeExifMetadata() {
        Optional<ExifMetadata> exifMetadata = imageExifReader.getExifMetadata(image);
        String exif = exifMetadata
                .map(ExifMetadata::getMetadata)
                .orElse(null);
        return exifMetadataService.createExifMetadata(CreateExifMetadataData.builder()
                .withMetadataType(MetadataTypes.FRAME)
                .withMetadata(exif)
                .build());
    }

    private FrameMetadataData storeFrameMetadata(Long frameId, Long exifMetadataId, double score) {
        return frameMetadataService.createFrameMetadata(CreateFrameMetadataData.builder()
                .withFrameId(frameId)
                .withExifMetadataId(exifMetadataId)
                .withMetadata(FrameProcessedMetadata.builder()
                        .withScore(score)
                        .build())
                .build());
    }

}
