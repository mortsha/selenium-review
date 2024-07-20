package week.two.css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsingCssSelector {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

       WebElement titleLocator =  driver.findElement(By.cssSelector(".home__categories-grid>div:nth-child(2)>h1"));
       String text = titleLocator.getText();
        System.out.println(text);

        driver.quit();

    }
}
