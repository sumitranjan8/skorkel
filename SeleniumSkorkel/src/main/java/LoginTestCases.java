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


}
