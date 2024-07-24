package utility.handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        // javascript alert handling
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/javascript-alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.findElement(By.id("alertBtn")).click();
        // option 1) switch to Alert after the alert popped up
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();

        Thread.sleep(1000);
        driver.quit();
    }
}
