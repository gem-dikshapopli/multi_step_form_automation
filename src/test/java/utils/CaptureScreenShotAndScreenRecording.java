package utils;

import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import stepDefinition.Hook;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class CaptureScreenShotAndScreenRecording {
    static int i = 1;
    static String folderPath = "src/ScreenShotsAndRecording/";
    static String timeStamp;
    public static ScreenRecorder screenRecorder;

    public static void captureScreenShot(WebElement element) throws IOException {
        /**
         *This will take the screenshot of the particular element
         */
        createDirectoryIfNeeded();
        File screenshot = element.getScreenshotAs(OutputType.FILE);
        timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File destinationFile = new File(folderPath + "File " + "_ " + (i++) + ".png");
        // Save the screenshot
        try {
            FileHandler.copy(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void recordingStart(int x, int y, int width, int height) throws IOException, AWTException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        File file = new File(folderPath + "Recording");
        Rectangle captureSize = new Rectangle(x, y, width, height);
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        screenRecorder = new ScreenRecorder(gc, captureSize, new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_ANIMATION,
                        CompressorNameKey, COMPRESSOR_NAME_QUICKTIME_ANIMATION, DepthKey, 24, FrameRateKey,
                        Rational.valueOf(15), QualityKey, 1.0f, KeyFrameIntervalKey, 15 * 60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                null, file);

        screenRecorder.start();
    }

    public static void captureElement() throws IOException, AWTException {
        WebElement element= Hook.driver.findElement(ObjectPaths.captureRecording);
        org.openqa.selenium.Point point = element.getLocation();
        org.openqa.selenium.Dimension size = element.getSize();

        int x = point.getX();
        int y = point.getY();
        int width = size.getWidth();
        int height = size.getHeight();

        recordingStart(x, y, width, height);
    }

    public static void recordingStop() throws Exception {
        screenRecorder.stop();
        renameRecordingFile();
    }

    private static void renameRecordingFile() {
        File directory = new File(folderPath + "Recording");
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".mov"));
        if (files != null && files.length == 1) {
            File originalFile = files[0];
            File renamedFile = new File(folderPath + "Recording/ScreenRecording.mp4");
            if (originalFile.renameTo(renamedFile)) {
                System.out.println("File renamed successfully");
            } else {
                System.out.println("File rename failed");
            }
        }
    }

    public static void captureFullPageScreenshot(WebDriver driver) throws IOException {
        /**
         * This will take the screenshot of the full page
         */
        createDirectoryIfNeeded();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File destinationFile = new File(folderPath + "FullPage_" + timeStamp + ".png");
        // Save the screenshot
        try {
            FileHandler.copy(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectoryIfNeeded() {
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
