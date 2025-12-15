package Buoi_8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Alert_Prompt{
public static void main(String[] args) throws InterruptedException {
    WebDriver driver;
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://anhit-basicform.surge.sh/");
    Thread.sleep(2000);

    driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
    Thread.sleep(2000);

    String prompt = "Example";

    driver.switchTo().alert().sendKeys(prompt);
    driver.switchTo().alert().accept();
    Thread.sleep(2000);

    WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
    Thread.sleep(2000);

    System.out.println(result.getText());
    Assert.assertEquals(result.getText(), "You entered: "+prompt);

    driver.quit();
}
}
