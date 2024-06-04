package implementation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CaptureScreenShotAndScreenRecording;
import utils.ExplicitWait;
import utils.GetFakeData;
import utils.ObjectPaths;
import static stepDefinition.Hook.driver;
public class Implementation {

    public static void switchToIframe(){
        driver.switchTo().frame(driver.findElement(By.id(ObjectPaths.IFRAME.getPaths())));
    }
    public static void validateUserOpensTheForm() {
        try{
            switchToIframe();
            ExplicitWait.elementIsClickable(By.xpath(ObjectPaths.REGISTER.getPaths()));
            if(driver.findElement(By.xpath(ObjectPaths.REGISTER.getPaths())).isDisplayed()){
                logger.Loggers.info("Form opens successfully");
            }
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsFirstName() {
        try{
            String firstName = GetFakeData.generateFakeFirstName();
            WebElement firstNameField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","First name...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(firstNameField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","First name..."))).sendKeys(firstName);
            logger.Loggers.info("user Fills the first name as = "+firstName);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsLastname() {
        try{
            String lastname=GetFakeData.generateFakeLastName();
            WebElement lastNameField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Last name...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(lastNameField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Last name..."))).sendKeys(lastname);
            logger.Loggers.info("user Fills the last name as = "+lastname);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userClicksOnNextButton(String buttonName) {
        try{
            WebElement clickOnButton=driver.findElement(By.id(ObjectPaths.NEXT_BUTTON.getPaths().replace("@text",buttonName)));
            CaptureScreenShotAndScreenRecording.captureScreenShot(clickOnButton);
            clickOnButton.click();
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsEmail() {
        try{
            String email=GetFakeData.generateEmail();
            WebElement emailField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","E-mail...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(emailField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","E-mail..."))).sendKeys(email);
            logger.Loggers.info("user Fills the email as = "+email);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsPhoneNumber() {
        try{
            String phoneNumber=GetFakeData.generatePhoneNumber();
            WebElement phoneNumberField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Phone...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(phoneNumberField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Phone..."))).sendKeys(phoneNumber);
            logger.Loggers.info("user Fills the phone number as = "+phoneNumber);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsBirthdayDate() {
        try{
            String birthdayDate=String.valueOf(GetFakeData.generateRandomNumber());
            WebElement birthDateField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","dd")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(birthDateField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","dd"))).sendKeys(birthdayDate);
            logger.Loggers.info("user Fills the phone number as = "+birthdayDate);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsBirthdayMonth() {
        try{
            String birthdayMonth=String.valueOf(GetFakeData.generateRandomMonth());
            WebElement birthMonthField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","mm")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(birthMonthField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","mm"))).sendKeys(birthdayMonth);
            logger.Loggers.info("user Fills the phone number as = "+birthdayMonth);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsBirthdayYear() {
        try{
            String birthdayYear=String.valueOf(GetFakeData.generateRandomYear());
            WebElement birthYearField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","yyyy")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(birthYearField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","yyyy"))).sendKeys(birthdayYear);
            logger.Loggers.info("user Fills the phone number as = "+birthdayYear);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsUsernameField() {
        try{
            String username=GetFakeData.generateUsername();
            WebElement userNameField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Username...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(userNameField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Username..."))).sendKeys(username);
            logger.Loggers.info("user Fills the last name as = "+username);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }

    public static void userFillsPassword() {
        try{
            String password=GetFakeData.generatePassword();
            WebElement passwordField=driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Password...")));
            CaptureScreenShotAndScreenRecording.captureScreenShot(passwordField);
            driver.findElement(By.xpath(ObjectPaths.NAME_OF_THE_FIELD.getPaths().replace("@text","Password..."))).sendKeys(password);
            logger.Loggers.info("user Fills the last name as = "+password);
        }catch (Exception e){
            logger.Loggers.warn("Exception "+e);
        }
    }
}
