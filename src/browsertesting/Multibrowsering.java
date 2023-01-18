package browsertesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import  org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Multibrowsering {
    static String browser = "chrome";
    static String baseurl = "http://demo.nopcommerce.com/";
    static WebDriver driver;

    public static void main(String[] args) {
         browser  = "edge";
         browser = "firefox";

        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.geco.driver", "src/drivers/geckodriver.exe"); //setting webriver
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("not valid browser ");
        }

        driver.get(baseurl);// method to invoke url
        driver.manage().window().maximize();  //maximising windows
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // timeout session

        String url = driver.getCurrentUrl();
        System.out.println("Current url"+ url);  // printing url

        driver.findElement(By.className("ico-login")).click();
        WebElement emailIDField = driver.findElement(By.id("Email")); //storin email
        emailIDField.sendKeys("abc@gmail.com"); //
        WebElement passwordField = driver.findElement(By.id("Password"));
        passwordField.sendKeys("123456");
        driver.findElement(By.className("buttons")).click();
        //driver.close();
        //driver.quit();
    }
}
