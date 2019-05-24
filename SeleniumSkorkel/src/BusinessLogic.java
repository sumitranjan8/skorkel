import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class BusinessLogic {

    private WebDriver driver = ConfigureDriver.get().getDriver();

    public void isLoggedIn(){
        String dashboard = ("Home");
        String dashboardName = driver.findElement(By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]")).getText();



        if (dashboardName.equals(dashboard)){
            System.out.println("......User Logined Successfully");
            HighlighterClass h = new HighlighterClass();
            h.highlighterElement();
            System.out.println(".....Element Highlighted...........");
            HighlighterClass.takeSnapShot("loginSuccess.png");
        }else{
            System.out.println("Login Failed");
            HighlighterClass.takeSnapShot("loginFailed.png");
        }

    }
}
