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
    public static void switchToIframe(){
        driver.switchTo().frame(driver.findElement(ObjectPaths.iframe));
    }
    public static void validateUserOpensTheForm() {
        try{
            switchToIframe();
            ExplicitWait.elementIsClickable(ObjectPaths.register);
            if(driver.findElement(ObjectPaths.register).isDisplayed()){
                logger.Loggers.info("Form opens successfully");
            }
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }
    public static void userClicksOnNextButton() {
        try{
            WebElement clickOnButton=driver.findElement(ObjectPaths.nextButton);
            CaptureScreenShotAndScreenRecording.captureScreenShot(clickOnButton);
            clickOnButton.click();
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsInTheField(Map<String,String> dataTable) throws IOException {
        WebElement fieldName;
        for(String key: dataTable.keySet()){
            switch (key) {
                case "firstName" -> {
                    String firstName = GetFakeData.generateFakeFirstName();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(firstName);
                    logger.Loggers.info("user Fills the first name as = " + firstName);
                }
                case "lastName" -> {
                    String lastname = GetFakeData.generateFakeLastName();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(lastname);
                    logger.Loggers.info("user Fills the last name as = " + lastname);
                    userClicksOnNextButton();
                }
                case "email" -> {
                    String email = GetFakeData.generateEmail();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(email);
                    logger.Loggers.info("user Fills the email as = " + email);
                }
                case "phoneNumber" -> {
                    String phoneNumber = GetFakeData.generatePhoneNumber();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(phoneNumber);
                    logger.Loggers.info("user Fills the phone number as = " + phoneNumber);
                    userClicksOnNextButton();
                }
                case "birthDate" -> {
                    String birthdayDate = String.valueOf(GetFakeData.generateRandomNumber());
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(birthdayDate);
                    logger.Loggers.info("user Fills the birth date as = " + birthdayDate);
                }
                case "birthMonth" -> {
                    String birthdayMonth = String.valueOf(GetFakeData.generateRandomMonth());
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(birthdayMonth);
                    logger.Loggers.info("user Fills the birth month as = " + birthdayMonth);
                }
                case "birthYear" -> {
                    String birthdayYear = String.valueOf(GetFakeData.generateRandomYear());
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(birthdayYear);
                    logger.Loggers.info("user Fills the birth year as = " + birthdayYear);
                    userClicksOnNextButton();
                }
                case "username" -> {
                    String username = GetFakeData.generateUsername();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(username);
                    logger.Loggers.info("user Fills the username as = " + username);
                }
                case "password" -> {
                    String password = GetFakeData.generatePassword();
                    fieldName=driver.findElement(ObjectPaths.fieldName(dataTable.get(key)));
                    CaptureScreenShotAndScreenRecording.captureScreenShot(fieldName);
                    driver.findElement(ObjectPaths.fieldName(dataTable.get(key))).sendKeys(password);
                    logger.Loggers.info("user Fills the password as = " + password);
                    userClicksOnNextButton();
                }
                default -> throw new RuntimeException("invalid key" + key);
            }

        }


    }
}
