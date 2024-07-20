package week.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {

        // navigate to google and search tek school and click on the first link
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.id("APjFqb"));
        searchInput.sendKeys("Tek School");

        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();

        driver.findElement(By.partialLinkText("TEK SCHOOL Modern")).click();

        driver.quit();
    }
}
