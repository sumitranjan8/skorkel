import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;



public class WallPost {


    @BeforeTest
    public void launchBrowser() {

        LaunchLandingPage obj1 = new LaunchLandingPage();
        obj1.launchLandingpage();
        Login userLogin = new Login();
        userLogin.login("s.ranjan+a@atlogys.com", "sumit@123");


    }



    @Test
    public static void postOnWall() {

        Utilities wallData = new Utilities();
        ArrayList data = wallData.readExcel("Wallpost");
//        System.out.println(data);
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));



        String post = String.valueOf(data.get(1));
        Login.sendData(Elements.postInputField, post);
        Login.clickEvent(Elements.postWallButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void screenshot() {
        Utilities.takeSnapShot("WallPost");
        ConfigureDriver.get().getDriver().close();
    }


}
