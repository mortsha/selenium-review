package utility.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ActivityTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Login"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("supervisor");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("tek_supervisor");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Plans"))).click();

        List<WebElement> tableRows = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody/tr/td[3]")));
        for(WebElement row: tableRows){
            System.out.println(row.getText());
        }


        driver.quit();
    }
}
