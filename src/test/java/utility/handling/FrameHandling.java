package utility.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FrameHandling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/iframe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.switchTo().frame(0);

        String text =  driver.findElement(By.xpath("//h1[contains(text(),'This page')]")).getText();
        System.out.println(text);

        driver.switchTo().defaultContent();
        String iframe = driver.findElement(By.xpath("//p[text()='Iframe']")).getText();
        System.out.println(iframe);

        driver.quit();
    }
}
