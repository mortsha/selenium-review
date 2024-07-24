package utility.handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertActivity {
    public static void main(String[] args) {
        // in the link click on alert prompt button and enter your name in the alert input and click ok
        // then get the text below the alert button and print it

        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("promptBtn"))).click();

//      option 1
//        Alert alert = driver.switchTo().alert();

        // option 2
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.sendKeys("Morteza");
        alert2.accept();
        String nameText = driver.findElement(By.id("message")).getText();
        System.out.println(nameText);


        driver.quit();
    }
}
