package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ActivityForUsefulMethods {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        SeleniumUtility utility = new SeleniumUtility(driver);
        driver.get("https://retail.tekschool-students.com/");
        utility.clickOnElement(By.linkText("Sign in"));
        utility.sendTextToElement(By.id("email"), "email@gmail.com");
        utility.sendTextToElement(By.id("password"), "wrongPass");
        utility.clickOnElement(By.id("loginBtn"));

        System.out.println(utility.getText(By.className("error")));

        driver.quit();


    }
}
