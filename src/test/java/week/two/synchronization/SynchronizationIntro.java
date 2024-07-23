package week.two.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SynchronizationIntro {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // applying Explicit wait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement signInButtonEle = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("signinLink"))));
        signInButtonEle.click();

        WebElement inputEmailEle =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("email"))));
        inputEmailEle.sendKeys("wrongEmail@gamil.com");

        WebElement inputPassEle = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("password"))));
        inputPassEle.sendKeys("wrongpassword");

        // simple method chaining
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn"))).click();

        WebElement errorEle=  wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        System.out.println(errorEle.getText());

        driver.quit();



    }
}
