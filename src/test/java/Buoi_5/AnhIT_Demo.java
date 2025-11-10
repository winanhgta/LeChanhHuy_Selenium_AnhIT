package Buoi_5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AnhIT_Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://anhitsolutions.com/login");
        Thread.sleep(2000);


        WebElement emailInput = driver.findElement(By.xpath("//input[@name='username']"));
        String email = "lechanhhuy03@gmail.com";
        emailInput.sendKeys(email);
        System.out.println(email);
        Thread.sleep(2000);


        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        String password = "chanhhuy393";
        System.out.println(password);
        passwordInput.sendKeys(password);
        Thread.sleep(2000);

        WebElement login = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div/form/button"));
        login.click();
        Thread.sleep(2000);


        driver.findElement(By.xpath("//a[@href='/panel/setting']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@type='tel']")).clear();
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0782747539");

        driver.findElement(By.xpath("//button[@id='saveData']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href, '/panel/setting/step/3')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//textarea[@name='about']")).sendKeys("Là một người từng mông lung trong việc tìm hiểu ngành nghề tester, AnhIT đã giúp tôi xác định và hướng dẫn các kiến thức cần thiết để trở thành một tester trong tương lai");

        driver.findElement(By.xpath("//button[@id='saveData']")).click();
    }
}
