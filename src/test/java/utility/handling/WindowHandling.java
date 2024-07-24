package utility.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException {
        /* to handle new tap with selenium
        get current window id before new tap open
        then open new tab.
        get all tabs id. make sure to have only 2 tab
        Loop through all tabs and switch to new tab when is not equal to current tab
         */

        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // step 1) get current window id
        String currentWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Test Selenium")).click();

        // step 2) find all the tabs id
        Set<String> allTabs = driver.getWindowHandles();

        // step 3) switch to new tab

        for(String tab: allTabs){
            if(!tab.equals(currentWindow)){
                driver.switchTo().window(tab);
                break;
            }
        }

        Thread.sleep(1000);
        driver.findElement(By.linkText("Inputs")).click();
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(currentWindow);
        Thread.sleep(2000);
        driver.quit();
    }
}
