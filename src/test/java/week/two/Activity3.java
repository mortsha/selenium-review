package week.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Activity3 {
    public static void main(String[] args) {
        // count how many buttons are there in BBC website

        WebDriver driver = new ChromeDriver();
        driver.get("https://bbc.com");
        driver.manage().window().maximize();
        List<WebElement> buttonsElements = driver.findElements(By.tagName("button"));
        System.out.println(buttonsElements.size());
        for(WebElement element: buttonsElements){
            String text = element.getText();
            if(!text.isEmpty()){
                System.out.println(text);
            }
        }
        driver.quit();
    }
}
