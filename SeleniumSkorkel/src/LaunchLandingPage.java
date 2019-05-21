import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLandingPage {

    private ConfigureDriver configureDriver= new ConfigureDriver();
    public void launchLandingpage(){
        configureDriver.settingBrowser();
        WebDriver driver = configureDriver.getDriver();
        driver.get("http://demo.guru99.com/");
        System.out.println("Application title is ============="+driver.getTitle());
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");
        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();
        driver.quit();
    }

    public static void main(String[] args) {
        LaunchLandingPage obj = new LaunchLandingPage();
        obj.launchLandingpage();

    }
}
