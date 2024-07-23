package week.two.synchronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity1 {
    public static void main(String[] args) {
        // retail up sign in with credential and go to account page
        // update phone number and validate success toast is displayed
        // your test should work without changing multiple time
        // apply implicit wait and explicit wait
        // use any locators available you like
        // push to repository

        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        signInBtn.click();
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailInput.sendKeys("mory123@gmail.com");
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passInput.sendKeys("Mory@123");

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
        loginBtn.click();
        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Account")));
        accountBtn.click();

        WebElement phoneNumberInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phoneNumber")));
        phoneNumberInput.clear();
        String phoneNumber = generateRandomPhoneNumber();
        phoneNumberInput.sendKeys(phoneNumber);
        WebElement updateBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("personalUpdateBtn")));
        updateBtn.click();
        WebElement updateSucBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify")));
        String actualUpdateSucText = updateSucBtn.getText();
        boolean isDisplayed = updateSucBtn.isDisplayed();
        String toastText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Toastify__toast div:last-child"))).getText();
        System.out.println(toastText);
        if(isDisplayed)
            System.out.println("Test is passed Toast Displayed");
        else
            System.out.println("Test failed");

        driver.quit();
    }

    private static String generateRandomPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 10);
            String intToString = String.valueOf(random);
            sb.append(intToString);
        }
        return sb.toString();
    }
}
