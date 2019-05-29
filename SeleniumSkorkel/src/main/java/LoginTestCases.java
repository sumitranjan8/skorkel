import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class LoginTestCases {

    @Test(priority = 1)
    public static void loginSuccess(){
        LaunchLandingPage obj = new LaunchLandingPage();
        obj.launchLandingpage();
        Login userLogin = new Login();
        userLogin.login("s.ranjan+a@atlogys.com", "sumit@123");
//        ConfigureDriver.get().getDriver().close();
//        ConfigureDriver.get().getDriver().quit();
    }

    @Test(priority = 2)
    public static void loginFailure(){
        LaunchLandingPage object2 = new LaunchLandingPage();
        object2.launchLandingpage();
        Login userLogin = new Login();
        userLogin.login("s.ranjan+a@atlogys.com", "su5mit@123");
        ConfigureDriver.get().getDriver().quit();

    }
}
