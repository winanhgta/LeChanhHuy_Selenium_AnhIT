package Buoi_6;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Dropdown_Default {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://egov.danang.gov.vn/reg");
        driver.manage().window().maximize();

        WebElement dropElement = driver.findElement(By.xpath("//select[@id='thuongtru_tinhthanh']"));
        Select selectCity = new Select(dropElement);

        List<WebElement> listCity = selectCity.getOptions();
        System.out.println("Số tỉnh thành: "+listCity.size());
        for (WebElement city : listCity){
            System.out.println("- "+city.getText());
        }

        Assert.assertFalse(selectCity.isMultiple(), "Dropdown khong duoc chon nhieu gia tri");

        selectCity.selectByVisibleText("tỉnh Khánh Hòa");
        Thread.sleep(2000);

        String selectedText = selectCity.getFirstSelectedOption().getText();
        System.out.println("Giá trị đã chọn: "+selectedText);
        Assert.assertEquals(selectedText, "tỉnh Khánh Hòa", "Giá trị không đúng");

        Assert.assertTrue(listCity.size()>0,"Dropdown khong co gia tri");

        driver.quit();
    }
}
