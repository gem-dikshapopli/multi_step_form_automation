package utils;

public enum ObjectPaths {
    OPEN_URL("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_form_steps"),
    REGISTER("//h1[contains(text(),'Register')]"),
    NAME_OF_THE_FIELD("//input[contains(@placeholder,'@text')]"),
    NEXT_BUTTON("nextBtn"),
    FINAL_DATA("//h1[contains(text(),'Submitted Form Data')]"),
    IFRAME("iframeResult");
    private final String paths;

    ObjectPaths(String paths) {
        this.paths = paths;
    }

    public String getPaths() {
        return paths;
    }
}
