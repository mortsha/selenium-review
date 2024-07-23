package utility.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("mory123@gmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("Mory@123");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn"))).click();


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Accessories']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'Mouse Combo Backlit')]"))).click();
        WebElement quantityEle = wait.until(ExpectedConditions.elementToBeClickable(By.className("product__select")));
        Select quantityDrop = new Select(quantityEle);
        quantityDrop.selectByValue("5");

        driver.findElement(By.id("addToCartBtn")).click();

        Thread.sleep(2000);
        driver.quit();

    }
}
