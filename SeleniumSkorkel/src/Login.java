import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

import java.lang.ref.SoftReference;

public class Login {

//    String UserName;
//    String Password;
    private WebDriver driver = ConfigureDriver.get().getDriver();

    public void login(String UserName, String Password)
    {

        driver.get("http://dev.skorkel.com");
        clickEvent(Elements.btn_login);
        sendData(Elements.UserName, UserName);
        sendData(Elements.Password,Password);
        clickEvent(Elements.btn_loginPopup);

        String dashboard = ("Home");
        String loginedDashboard = driver.findElement(By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]")).getText();
        if (loginedDashboard.equals(dashboard)){
            System.out.println("User Logined Successfully");
        }
        else{
            System.out.println("Login Failed");

        }

    /*   // Wait for 5 Sec
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    driver.quit();
	    */
    }

    public WebElement elementFinder(By locator){
        try {
           WebElement element= driver.findElement(locator);
           return element;
        }catch (NoSuchElementException e){
            e.getMessage();
            System.out.println("... Element not found b locator: "+locator);
            return null;
        }

    }

    public boolean clickEvent(By locator){
        try {
           WebElement element = driver.findElement(locator);
           element.click();
           return true;
        }catch (NoSuchElementException e){
            e.getMessage();
            System.out.println("... Element not found b locator: "+locator);
            return false;
        }

    }

    public boolean sendData(By locator, String inputData){
        try {
           WebElement element = driver.findElement(locator);
           element.sendKeys(inputData);
           return true;
        }catch (NoSuchElementException e){
            e.getMessage();
            System.out.println("... Element not found b locator: "+locator);
            return false;
        }

    }


}
