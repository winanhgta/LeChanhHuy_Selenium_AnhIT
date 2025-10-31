import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ElementSelector {
    private static WebDriver driver;

    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // An implicit wait tells WebDriver to poll the DOM for a certain amount of time
        // when trying to find an element. This is a simple way to handle page load times.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1. Find the username field by its CLASS NAME and enter the username.
        // `findElement` with a shared class name will return the first one it finds.
        WebElement usernameInput = driver.findElement(By.className("oxd-input"));
        usernameInput.sendKeys("Admin");

        // 2. Find the password field by its NAME attribute and enter the password.
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("admin123");

        // It's crucial to close the browser after your automation task is complete to free up resources.
        driver.quit();
    }
}
