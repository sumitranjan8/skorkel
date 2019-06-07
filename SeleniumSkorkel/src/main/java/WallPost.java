
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class WallPost {
    @Test (priority = 1)
    public static void postOnWall(){

        LaunchLandingPage obj1 = new LaunchLandingPage();
        obj1.launchLandingpage();
        Login userLogin = new Login();
        userLogin.login("s.ranjan+a@atlogys.com", "sumit@123");

        String post = "xyz";

        Login.sendData(Elements.postInputField, post );
        Login.clickEvent(Elements.postWallButton);

        System.out.println(".....Posted Successfully. ...........");


        ConfigureDriver.get().getDriver().quit();




    }











}
