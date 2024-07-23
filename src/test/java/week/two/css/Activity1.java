package week.two.css;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
        // in retail app navigate to sign in and login with credential and after sign in
        // to account page and print profile email
        // using css selector
        WebDriver driver = new ChromeDriver();
        driver.get("https://retail.tekschool-students.com/");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#signinLink")).click();
        String emailUnique = "Mory123@gmail.com";
        driver.findElement(By.cssSelector("#email")).sendKeys(emailUnique);
        driver.findElement(By.cssSelector("#password")).sendKeys("Mory@123");
        driver.findElement(By.cssSelector("#loginBtn")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#accountLink")).click();
        WebElement accountEmailInfo = driver.findElement(By.cssSelector(".account__information-email"));
        String textAccountEmailInfo = accountEmailInfo.getText();

        if(emailUnique.equalsIgnoreCase(textAccountEmailInfo)){
            System.out.println("you are in your account and your email is: ");
            System.out.println(textAccountEmailInfo);
        }else{
            System.err.println("You are not in your account");
        }
        Thread.sleep(1000);
        driver.quit();

    }

    public By getButtonLocator(String buttonText){
        return By.xpath("//button[text()='"+buttonText+"']");
    }
}
