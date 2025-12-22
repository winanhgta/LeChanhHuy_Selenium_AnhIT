package Buoi_10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class TabSwitchByTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String parentID = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/OrangeHRM/']")).click();
        Thread.sleep(2000);

        String expectedTitle = "OrangeHRM Inc - Youtube";
        Set<String> allWindows = driver.getWindowHandles();

        for (String winID : allWindows){
            driver.switchTo().window(winID);
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }
        }

        Thread.sleep(2000);
        System.out.println("Đã chuyển đến tab có Title: "+driver.getTitle());

        driver.quit();

    }
}
