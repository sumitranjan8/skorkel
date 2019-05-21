import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigureDriver {
    WebDriver driver;

    public void settingBrowser(){
        setDriver("firefox");
    }

    private void setDriver(String browserName){

        String driverPath = System.getProperty("user.dir")+"/Resources/Drivers/";
        System.out.println(driverPath);

        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }


}