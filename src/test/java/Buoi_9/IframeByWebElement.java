package Buoi_9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class IframeByWebElement {
    public static void main(String[] args){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://anhitsolutions.com/contact");

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='YouTube video player']"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//button[contains(@class, 'ytp-large-play-button')]")).click();

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[@href='/classes?sort=newest']")).click();

        driver.quit();
    }
}
