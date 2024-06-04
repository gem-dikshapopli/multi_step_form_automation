package utils;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CaptureScreenShotAndScreenRecording {
    static int i=1;
    static String folderPath="src/ScreenShotsAndRecording/";
    static ATUTestRecorder atuTestRecorder;
    static String timeStamp;
    public static void captureScreenShot(WebElement element)throws IOException{
        /**
         *This will take the screenshot of the particular element
         */
        createDirectoryIfNeeded();
        File screenshot= element.getScreenshotAs(OutputType.FILE);
         timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File destinationFile=new File(folderPath+"File "+"_ "+(i++)+".png");
        // Save the screenshot
        try {
            FileHandler.copy(screenshot, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startRecording() throws ATUTestRecorderException {
        atuTestRecorder=new ATUTestRecorder(folderPath+"Recording",false);
        atuTestRecorder.start();
    }

    public static void stopRecording() throws ATUTestRecorderException {
        atuTestRecorder.stop();
    }

    private static void createDirectoryIfNeeded() {
        File directory = new File(folderPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
