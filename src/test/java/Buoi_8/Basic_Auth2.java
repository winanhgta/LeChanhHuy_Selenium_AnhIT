package Buoi_8;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Basic_Auth2 {
    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://anhitsolutions.cloud/");
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.setAutoDelay(120);
        type(robot, KeyEvent.VK_A);
        type(robot, KeyEvent.VK_N);
        type(robot, KeyEvent.VK_H);
        type(robot, KeyEvent.VK_I);
        type(robot, KeyEvent.VK_T);
        type(robot, KeyEvent.VK_MINUS);
        type(robot, KeyEvent.VK_U);
        type(robot, KeyEvent.VK_S);
        type(robot, KeyEvent.VK_E);
        type(robot, KeyEvent.VK_R);
        type(robot, KeyEvent.VK_TAB);

        type(robot, KeyEvent.VK_A);
        type(robot, KeyEvent.VK_N);
        type(robot, KeyEvent.VK_H);
        type(robot, KeyEvent.VK_I);
        type(robot, KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_SHIFT);
        type(robot, KeyEvent.VK_2);
        robot.keyPress(KeyEvent.VK_SHIFT);
        type(robot, KeyEvent.VK_2);
        type(robot, KeyEvent.VK_0);
        type(robot, KeyEvent.VK_2);
        type(robot, KeyEvent.VK_5);

        type(robot, KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }

    private static void type(Robot robot, int key) {
        robot.keyPress(key);
        robot.keyRelease(key);
    }
}
