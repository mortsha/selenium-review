package utility.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.SeleniumUtility;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev.insurance.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        SeleniumUtility utility = new SeleniumUtility(driver);
        utility.clickOnElement(By.linkText("Login"));
        utility.sendTextToElement(By.id("username"), "supervisor");
        utility.sendTextToElement(By.id("password"), "tek_supervisor");
        utility.clickOnElement(By.xpath("//button[text()='Sign In']"));
        utility.clickOnElement(By.linkText("Plans"));
        List<WebElement> tableRows = utility.getElements(By.xpath("//table/tbody/tr"));

        Map<String,String> plans = new HashMap<>();


        for (int row = 0; row < tableRows.size(); row++) {
            String xpathForPlanType = "//table/tbody/tr[" + (row + 1) + "]/td[2]";
            String xpathForPrice = "//table/tbody/tr[" + (row + 1) + "]/td[3]";

            String planTypeKey = utility.getText(By.xpath(xpathForPlanType));
            String planPriceValue = utility.getText(By.xpath(xpathForPrice));

            plans.put(planTypeKey,planPriceValue);


        }
        System.out.println(plans);
        driver.quit();

    }
}
