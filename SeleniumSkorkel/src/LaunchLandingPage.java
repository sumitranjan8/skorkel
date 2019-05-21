import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LaunchLandingPage {

    private ConfigureDriver configureDriver= new ConfigureDriver();
    public void launchLandingpage(){
        configureDriver.settingBrowser();
        WebDriver driver = configureDriver.getDriver();
        driver.get("http://uat.skorkel.com");
        System.out.println("Application title is ============="+driver.getTitle());
        WebElement button=driver.findElement(By.xpath("//*[@class='btn btn-primary login-popup']"));
        button.click();
        WebElement username=driver.findElement(By.xpath("//*[@id=\"UserName\"]"));
        username.sendKeys("s.ranjan+a@atlogys.com");
        WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        password.sendKeys("sumit@123");
        WebElement loginButton=driver.findElement(By.xpath("//*[@id=\"Login1_button\"]"));
        loginButton.click();
        System.out.println("User Logined Sussessfully");
        driver.quit();
    }

//    public static void main(String[] args) {
//        LaunchLandingPage obj = new LaunchLandingPage();
//        obj.launchLandingpage();
//
//    }
}
