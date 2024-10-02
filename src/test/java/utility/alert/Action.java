package utility.alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utility.SeleniumUtility;

public class Action {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("");
        Actions actions = new Actions(driver);


    }
}
