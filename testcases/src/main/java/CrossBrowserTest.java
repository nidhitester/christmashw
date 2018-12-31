
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
    WebDriver driver;
    @Test
    @Parameters
     public void verify_page(String browserName){
        if (browserName.equalsIgnoreCase("firefox")){

            driver=new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("Chrome")){
System.setProperty("webdriver.chrome.driver","src\\main\\java\\ChromeDriver\\chromedriver.exe");
            driver=new ChromeDriver();
        }

        else if (browserName.equalsIgnoreCase("IE")){

            System.setProperty("webdriver.ie.driver","src\\main\\java\\Internetexolorer\\IEDriverServer.exe");
            driver=new InternetExplorerDriver();
        }

        driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com");
        System.out.println(driver.getTitle());

        driver.quit();


    }
}



