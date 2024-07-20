package OpenBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class UserBrowserRequest {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose browser chrome, firefox or edge");
        String userBrowser = scanner.next();
        WebDriver driver;

        if(userBrowser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(userBrowser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(userBrowser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }else{
            throw new RuntimeException("Wrong browser of typo");
        }
        driver.get("https://google.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.quit();
    }
}
