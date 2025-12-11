package Buoi_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions; // Import cần thiết
import org.testng.Assert;

public class BypassCloudflare {

    public static void main(String[] args) throws InterruptedException {
        // Cấu hình ChromeOptions (Giữ nguyên phần chống phát hiện)
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

        // Khởi tạo WebDriver
        WebDriver driver = new ChromeDriver(options);

        // Khởi tạo Actions Class
        Actions actions = new Actions(driver);

        driver.get("https://demo.nopcommerce.com/");
        Thread.sleep(5000); // Chờ Cloudflare check

        // --- 1. Xử lý Cloudflare (Nếu hộp kiểm vẫn còn) ---
        // Sau khi chờ 5s, nếu trang vẫn hiển thị hộp kiểm Cloudflare, bạn cần xác định
        // và tương tác với nó trước khi tiếp tục.
        // (Giả sử bạn đã qua Cloudflare và đang ở trang chủ)

        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        Thread.sleep(2000); // Chờ trang Đăng ký tải xong (Giảm thời gian chờ quá lâu)

        // Định vị Checkbox
        WebElement newLetterCheckBox = driver.findElement(By.xpath("//input[@id='Newsletter']")); // Sử dụng ID chính xác

        if(!newLetterCheckBox.isSelected()){
            System.out.println("Checkbox chưa được chọn, tiến hành click bằng Actions Class...");

            // --- Áp dụng Actions Class để mô phỏng click tự nhiên hơn ---

            // 1. Di chuyển chuột đến Checkbox
            actions.moveToElement(newLetterCheckBox).perform();

            // 2. Thêm một chút delay ngẫu nhiên (Optional, nhưng hữu ích)
            Thread.sleep(800);

            // 3. Thực hiện Click
            actions.click(newLetterCheckBox).perform();

            // --- Kết thúc Actions Class ---
        } else {
            System.out.println("Checkbox đã được chọn sẵn.");
        }

        // Kiểm tra sau khi click
        Assert.assertTrue(newLetterCheckBox.isSelected(), "Checkbox Newsletter chưa được chọn sau khi tương tác.");

        System.out.println("Trạng thái checkbox: "+newLetterCheckBox.isSelected());

        Thread.sleep(5000);

        // Đóng trình duyệt
        // driver.quit();
    }
}