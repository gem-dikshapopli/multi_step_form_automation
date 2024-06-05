package utils;

import org.openqa.selenium.By;

public enum ObjectPaths {
    OPEN_URL("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_form_steps"),
    REGISTER("//h1[contains(text(),'Register')]"),
    NAME_OF_THE_FIELD("//input[contains(@placeholder,'@text')]"),
    NEXT_BUTTON("nextBtn"),
    IFRAME("iframeResult");
    private final String paths;

    ObjectPaths(String paths) {
        this.paths = paths;
    }

    public String getPaths() {
        return paths;
    }

    public static String openUrl="https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_form_steps";
    public static By register=By.xpath("//h1[contains(text(),'Register')]");
    public static By fieldName(String nameOfField){return By.xpath("//input[contains(@placeholder,"+nameOfField+")]");}
    public static By nextButton=By.id("nextBtn");
    public static By iframe=By.id("iframeResult");

}
