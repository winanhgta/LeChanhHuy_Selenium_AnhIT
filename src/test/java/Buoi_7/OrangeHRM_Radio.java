package Buoi_7;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;
public class OrangeHRM_Radio {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Đăng nhập vào trang với username và password
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        // Chuyển sang trang My Info
        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        Thread.sleep(2000);

        // Chọn giới tính
        WebElement genderButton = driver.findElement(By.xpath("//label[text()='Female']//span"));
        genderButton.click();
        Thread.sleep(2000);
        //Assert.assertTrue(genderButton.isSelected(),"Nút giới tính nữ chưa được chọn");

        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement femaleRadio = driver.findElement(By.xpath("//label[text()='Male']//span"));
        js.executeScript("arguments[0].click()", femaleRadio);
        Thread.sleep(2000);

        driver.quit();
    }
}
