import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LaunchLandingPage {


    String url = "http://dev.skorkel.com/";


    public void launchLandingpage() {
        ConfigureDriver.get().settingBrowser();
        WebDriver driver = ConfigureDriver.get().getDriver();
//        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(url);
        System.out.println("......Application title is =============" + driver.getTitle());
        int titleLength = driver.getTitle().length();
        System.out.println("Length of the title is : " + titleLength);
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(url)) {
            System.out.println("Verification Successful - The correct Url is opened.");
        } else {
            System.out.println("Verification Failed - An incorrect Url is opened.");

            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }
        System.out.println("Successfully opened the website http://dev.skorkel.com");
        //driver.quit();

    }
}
