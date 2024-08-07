import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GuviLoginPage {
    public static void main(String[] args) throws InterruptedException {
        //launch web driver
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver=new ChromeDriver(options);

        //Maximize the window
        driver.manage().window().maximize();

        //Navigate to URL
        driver.get("https://www.guvi.in/");

        //adding Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Locate Signup Button &Click
        WebElement SignupButton= driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']"));
        SignupButton.click();

        //Filling the required details in signup
        WebElement name= driver.findElement(By.xpath("//input[@class='form-control' and @id='name']"));
        name.sendKeys("ANBU");

        WebElement emailid= driver.findElement(By.xpath("//input[@class='form-control' and @id='email']"));
        emailid.sendKeys("Saranya291295@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Saranya@29cse");

        WebElement mobilenumber= driver.findElement(By.xpath("//input[@id='mobileNumber']"));
        mobilenumber.sendKeys("7373329541");


        WebElement SignUp= driver.findElement(By.xpath("//a[@id='signup-btn']"));
        SignUp.click();

        WebElement maybelater= driver.findElement(By.xpath("//a[@id='laterBtn']"));
        maybelater.click();


        //Verifying signup process
        WebElement welcomequote= driver.findElement(By.xpath("//div[@class='left-head']/h1"));
        welcomequote.getText();

        if (welcomequote.getText().equals("Almost Done! Check Your Inbox!"))
        {
            System.out.println("Signup successful!");
        }
        else
        {
            System.out.println("Signup failed!");
        }

        //Its dummy id we can't open gmail, so I directly instruct to navigate
        driver.navigate().back();

        //Login
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='nav-link  text-primary text-center px-4']"));
        loginButton.click();

        WebElement loginEmail= driver.findElement(By.xpath("//input[@id='email']"));
        loginEmail.sendKeys("saranya291295@gmail.com");

        WebElement loginPassword= driver.findElement(By.xpath("//input[@id='password']"));
        loginPassword.sendKeys("Saranya@29cse");

        WebElement loginSubmit= driver.findElement(By.xpath("//a[@id='login-btn']"));
        loginSubmit.click();

        //Due to delay it's not locating properly so that I tried with sleep
        Thread.sleep(5000);

        // Verify login success by checking the page title
        String PageTitle=driver.getTitle();

        if (PageTitle.equals("GUVI | courses")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}
