package utils;

import org.openqa.selenium.By;

public class ObjectPaths {
    public static String openUrl = "https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_form_steps";
    public static By register = By.xpath("//h1[contains(text(),'Register')]");

    public static By fieldName(String nameOfField) {
        return By.xpath("//input[contains(@placeholder," + nameOfField + ")]");
    }

    public static By nextButton = By.id("nextBtn");
    public static By iframe = By.id("iframeResult");

}
