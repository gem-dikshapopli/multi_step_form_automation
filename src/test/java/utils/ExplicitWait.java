package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static stepDefinition.Hook.driver;

import java.time.Duration;

public class ExplicitWait {

    public static WebDriverWait visibilityOfElement(By path){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        return (WebDriverWait) wait.until(ExpectedConditions.visibilityOfElementLocated(path));
    }
    public static WebDriverWait elementIsClickable(By path){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        return (WebDriverWait) wait.until(ExpectedConditions.elementToBeClickable(path));
    }



}
