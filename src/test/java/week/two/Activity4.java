package week.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity4 {
    public static void main(String[] args) throws InterruptedException {
        // retail app click on video games then choose ps5 console then click
        // on add to cart
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@alt='Video Games']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//img[@alt='PlayStation 5 Console']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@id='addToCartBtn']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
