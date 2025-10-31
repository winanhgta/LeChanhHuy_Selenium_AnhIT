import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath {
    private static WebDriver driver;

    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Use an implicit wait for simplicity in this exercise.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // --- 1. Find the username field using an ABSOLUTE XPath ---
        // This path is very long and fragile. If any element in the path changes, this locator will break.
        WebElement usernameInput = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
        usernameInput.sendKeys("Admin");

        // --- 2. Find the password field using a RELATIVE (Approximate) XPath ---
        // This path is short, readable, and robust. It finds the input field with the name 'password' anywhere on the page.
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("admin123");

        // --- 3. Find the login button using a RELATIVE XPath and click it ---
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Pause for a moment to see the result before the browser closes.
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}