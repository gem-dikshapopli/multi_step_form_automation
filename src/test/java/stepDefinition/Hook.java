package stepDefinition;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CaptureScreenShotAndScreenRecording;
import utils.ObjectPaths;

import java.awt.*;
import java.io.IOException;
import java.time.Duration;

public class Hook {
        public static WebDriver driver=new ChromeDriver();

        @Before
        public static void setUpTheDriver() throws IOException, AWTException {
           System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(utils.ObjectPaths.openUrl);
            CaptureScreenShotAndScreenRecording.recordingStart();
        }

        @After
        public void tearDown() throws Exception {
            CaptureScreenShotAndScreenRecording.recordingStop();
            driver.quit();

        }
        public static WebDriver getDriver(){
            return driver;
        }
}
