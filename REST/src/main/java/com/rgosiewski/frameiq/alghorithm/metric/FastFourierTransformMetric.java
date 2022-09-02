/*
 * Copyright © 2022 Rafał Gosiewski
 * All rights reserved
 */

package com.rgosiewski.frameiq.alghorithm.metric;

import com.rgosiewski.frameiq.alghorithm.exception.ImageProcessingException;
import nu.pattern.OpenCV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FastFourierTransformMetric extends ImageProcessingAlgorithm {
    private final Logger logger = LogManager.getLogger(FastFourierTransformMetric.class);

    @Override
    public double calculateMetric(Path imagePath) {
        OpenCV.loadLocally();
        Mat image = Imgcodecs.imread(imagePath.toString());
        Mat imageGrey = new Mat();
        double FFT = 0.0;
        try {
            if (!image.empty()) {
                Imgproc.cvtColor(image, imageGrey, Imgproc.COLOR_RGBA2GRAY, 0);
                // get optimal size of DFT
                int optimalRows = Core.getOptimalDFTSize(imageGrey.rows());
                int optimalCols = Core.getOptimalDFTSize(imageGrey.cols());
                Scalar s0 = Scalar.all(0);
                Mat padded = new Mat();
                Core.copyMakeBorder(imageGrey, padded, 0, optimalRows - imageGrey.rows(), 0,
                        optimalCols - imageGrey.cols(  ), Core.BORDER_CONSTANT, s0);
                // use cv.MatVector to distribute space for real part and imaginary part
                // MatVector is replaced with collection
                Mat plane0 = new Mat();
                padded.convertTo(plane0, CvType.CV_32F);
                List<Mat> planes = new LinkedList<>();
                Mat complexI = new Mat();
                Mat plane1 = Mat.zeros(padded.rows(), padded.cols(), CvType.CV_32F);
                planes.add(plane0);
                planes.add(plane1);
                Core.merge(planes, complexI);
                //Imgcodecs.imwrite(imagePath.getParent().resolve("complexI_"+imagePath.getFileName()).toString(), complexI);

                // in-place dft transform
                Mat complexIb = new Mat();
                Core.dft(complexI, complexIb);
                //Imgcodecs.imwrite(imagePath.getParent().resolve("dft_"+imagePath.getFileName()).toString(), complexIb);
                // compute log(1 + sqrt(Re(DFT(img))**2 + Im(DFT(img))**2))
                Mat splited = new Mat();
                Mat magnitude = new Mat();
                Core.split(splited, planes);
                Core.magnitude(planes.get(0), planes.get(1), magnitude);
                Mat m1 = Mat.ones(magnitude.rows(), magnitude.cols(), magnitude.type());
                Mat magAdded = new Mat();
                Core.add(magnitude, m1, magAdded);
                Mat magLog = new Mat();
                Core.log(magAdded, magLog);
                // crop the spectrum, if it has an odd number of rows or columns
                Rect roi = new Rect(0, 0, magLog.cols() & - 2, magLog.rows() & - 2);
                Mat magRoi = new Mat();
                magRoi = magLog.submat(roi);
                // rearrange the quadrants of Fourier image
                // so that the origin is at the image center
                int cx = magRoi.cols() / 2;
                int cy = magRoi.rows() / 2;
                Mat tmp = new Mat();

                Rect rect0 = new Rect(0, 0, cx, cy);
                Rect rect1 = new Rect(cx, 0, cx, cy);
                Rect rect2 = new Rect(0, cy, cx, cy);
                Rect rect3 = new Rect(cx, cy, cx, cy);

                Mat q0 = magRoi.submat(rect0);
                Mat q1 = magRoi.submat(rect1);
                Mat q2 = magRoi.submat(rect2);
                Mat q3 = magRoi.submat(rect3);

                // exchange 1 and 4 quadrants
                q0.copyTo(tmp);
                q3.copyTo(q0);
                tmp.copyTo(q3);

                // exchange 2 and 3 quadrants
                q1.copyTo(tmp);
                q2.copyTo(q1);
                tmp.copyTo(q2);

                // The pixel value of cv.CV_32S type image ranges from 0 to 1.
                Mat normalized = new Mat();
                Core.normalize(magRoi, normalized, 0, 1, Core.NORM_MINMAX);
                logger.info("FFT for image {}: {}", imagePath.toString(), FFT);
            }
        } catch (Exception e) {
            logger.error("Error calculating FFT for image {}", imagePath.getFileName());
            throw new ImageProcessingException(imagePath);
        }
        return FFT;
    }
}
