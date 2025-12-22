package Buoi_9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class IframeByIdOrName {
    public static void main (String[] args){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo");

        driver.switchTo().frame("frame1");

        driver.findElement(By.id("frame")).sendKeys("Hello iframe");

        driver.switchTo().defaultContent();

        driver.quit();
    }
}
