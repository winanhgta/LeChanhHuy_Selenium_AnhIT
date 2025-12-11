package Buoi_6;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class Checkbox_NopCommerce {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        Thread.sleep(20000);

        WebElement newLetterCheckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        if(!newLetterCheckBox.isSelected()){
            newLetterCheckBox.click();
        } else {
            System.out.println("Checkbox đã được chọn");
        }

        Assert.assertTrue(newLetterCheckBox.isSelected(), "Checkbox chưa được chọn");

        System.out.println("Trạng thái checkbox: "+newLetterCheckBox.isSelected());

        driver.quit();

    }
}
