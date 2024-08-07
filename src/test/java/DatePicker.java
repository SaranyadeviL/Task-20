import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DatePicker {
    public static void main(String[] args) {
        //Initiate the web browser
        WebDriver driver = new ChromeDriver();

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate the website
        driver.get("http://jqueryui.com/datepicker/");

        //adding Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Switch to iframe
        WebElement iframe= driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
        driver.switchTo().frame(iframe);

        WebElement DatePicker= driver.findElement(By.id("datepicker"));
        DatePicker.click();

        //Select next month
        WebElement nextmonth=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
        nextmonth.click();

        //Select june 22nd date
        WebElement selectdate= driver.findElement(By.xpath("//td/a[text()='22']"));
        selectdate.click();

        //Retrieve the Selected Date
        String selectedDate=DatePicker.getAttribute("value");
        System.out.println("The Selected Date is : "+selectedDate);

        //Close the current window
        driver.close();

        //Quit the WebDriver Session
        driver.quit();

    }

}
