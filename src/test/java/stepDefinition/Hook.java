package stepDefinition;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CaptureScreenShotAndScreenRecording;
import utils.ObjectPaths;

import java.time.Duration;

public class Hook {
        public static WebDriver driver=new ChromeDriver();

        @Before
        public static void setUpTheDriver() throws ATUTestRecorderException {
           System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            driver.get(ObjectPaths.OPEN_URL.getPaths());
            CaptureScreenShotAndScreenRecording.startRecording();
        }

        @After
        public void tearDown() throws ATUTestRecorderException {
            CaptureScreenShotAndScreenRecording.stopRecording();
            driver.quit();

        }
        public static WebDriver getDriver(){
            return driver;
        }
}
