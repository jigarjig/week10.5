package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxTest {
    public static void main(String[] args) {


        String baseurl = "http://demo.nopcommerce.com/"; // storing base url
        System.setProperty("webdriver.geco.driver", "src/drivers/geckodriver.exe"); //setting firefox webdriver
        WebDriver driver = new FirefoxDriver(); // creatin object of chrome webdriver
        driver.get(baseurl); // method to invoke url

        driver.manage().window().maximize();  //maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // timeout session

        String title = driver.getTitle();
        System.out.println("Title of the page :"+ title);  // printing title
        String url = driver.getCurrentUrl();
        System.out.println("Current url"+ url);  // printing url
        String source = driver.getPageSource();
        System.out.println("page source :"+ source);
        System.out.println("Title of the page :"+ url);
        driver.findElement(By.className("ico-login")).click();
        WebElement emailIDField = driver.findElement(By.id("Email")); //storin email
        emailIDField.sendKeys("abc@gmail.com");
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("123456");
        driver.findElement(By.className("buttons")).click();
        // driver.close();

    }
}




