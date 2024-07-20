package OpenBrowser;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowser {
    public static void main(String[] args) {
        ChromeDriver chrome = new ChromeDriver();
        chrome.manage().window().maximize();
        chrome.get("https://google.com");

        String title = chrome.getTitle();
        System.out.println(title);
        chrome.quit();
    }
}
