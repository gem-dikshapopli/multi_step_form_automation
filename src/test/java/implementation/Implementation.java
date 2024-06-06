package implementation;

import org.openqa.selenium.WebElement;
import utils.CaptureScreenShotAndScreenRecording;
import utils.ExplicitWait;
import utils.GetFakeData;
import utils.ObjectPaths;

import java.io.IOException;
import java.util.Map;

import static stepDefinition.Hook.driver;

public class Implementation {
    public static void switchToIframe() {
        driver.switchTo().frame(driver.findElement(ObjectPaths.iframe));
    }

    public static void validateUserOpensTheForm() {
        try {
            switchToIframe();
            ExplicitWait.elementIsClickable(ObjectPaths.register);
            if (driver.findElement(ObjectPaths.register).isDisplayed()) {
                logger.Loggers.info("Form opens successfully");
            }
        } catch (Exception e) {
            logger.Loggers.warn("Exception " + e);
//            logger.Loggers.warn("Exception "+e.getMessage());

        }
    }

    public static void userClicksOnNextButton() {
        try {
            WebElement clickOnButton = driver.findElement(ObjectPaths.nextButton);
            CaptureScreenShotAndScreenRecording.captureScreenShot(clickOnButton);
            clickOnButton.click();
        } catch (Exception e) {
            logger.Loggers.warn("Exception " + e);
        }
    }

    public static void userFillsTheData(Map<String, String> dataTable, String key) throws IOException {
        WebElement fieldName;
        String nameOfTheField = GetFakeData.generateFakeData(key);
        fieldName = driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
        CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
        driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(nameOfTheField);
        logger.Loggers.info("user Fills the " + key + " = " + nameOfTheField);
    }

    public static void userFillsInTheField(Map<String, String> dataTable) throws IOException {

        for (String key : dataTable.keySet()) {
            switch (key) {
                case "firstName", "email", "birthDate", "birthMonth", "username" -> {
                    userFillsTheData(dataTable, key);
                }
                case "lastName", "phoneNumber", "birthYear", "password" -> {
                    userFillsTheData(dataTable, key);
                    userClicksOnNextButton();
                }
                default -> throw new RuntimeException("invalid key" + key);
            }

        }


    }
}
