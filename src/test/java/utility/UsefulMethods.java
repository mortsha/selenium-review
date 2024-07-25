package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsefulMethods {
    WebDriver driver;
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.name("email")).sendKeys("anyemail@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Password!2");
        boolean isButtonEnabled = driver.findElement(By.id("loginBtn")).isEnabled();
        System.out.println(isButtonEnabled);


    }
    public static void clickOnElement(WebDriver driver , By locator){
        driver.findElement(locator).click();
    }
}
