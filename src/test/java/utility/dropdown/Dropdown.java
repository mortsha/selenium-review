package utility.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/selenium/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement dropdownEle = wait.until(ExpectedConditions.elementToBeClickable(By.id("programmingLanguageSelect")));
        Select programmingSelect = new Select(dropdownEle);
        programmingSelect.selectByValue("python");

        WebElement countryEle = driver.findElement(By.id("languageSelect"));
        Select countryDp = new Select(countryEle);
        List<WebElement> options = countryDp.getOptions();
        int size = options.size();
        countryDp.selectByIndex(size - 1);


        Thread.sleep(2000);
        driver.quit();


    }
}
