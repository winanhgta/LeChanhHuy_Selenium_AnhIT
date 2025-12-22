package Buoi_10;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class TabSwitchById {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String parentID = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/OrangeHRMInc']")).click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String winID : allWindows){
            if (!winID.equals(parentID)){
                driver.switchTo().window(winID);
                break;
            }
        }

        Thread.sleep(2000);
        System.out.println("Title tab mới: "+driver.getTitle());

        driver.close();

        driver.switchTo().window(parentID);

        System.out.println("Title tab cha: "+driver.getTitle());

        driver.quit();

    }
}
