import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class Login {

    String UserName;
    String Password;
    private WebDriver driver = ConfigureDriver.get().getDriver();

    public void login(String UserName, String Password)
    {

        driver.get("http://dev.skorkel.com");
        driver.findElement(By.xpath("//*[@class='btn btn-primary login-popup']")).click();
        driver.findElement(By.xpath("//*[@id=\"UserName\"]")).sendKeys(UserName);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(Password);
        driver.findElement(By.xpath("//*[@id=\"Login1_button\"]")).click();

//        String dashboard = ("Home");
//        String loginedDashboard = driver.findElement(By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]"));
//        if (loginedDashboard.equals(dashboard)){
//            System.out.println("User Logined Successfully");
//        }
//        else{
//            System.out.println("Login Failed");
//
//        }

//        Wait for 5 Sec
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    driver.quit();
    }


}
