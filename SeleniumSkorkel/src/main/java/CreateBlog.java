import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreateBlog {


    @BeforeTest
    public void launchBrowser()
    {

        LaunchLandingPage obj1 = new LaunchLandingPage();
        obj1.launchLandingpage();
        Login userLogin = new Login();
        userLogin.login("s.ranjan+a@atlogys.com", "sumit@123");


    }

    @Test
    public static void postOnWall()
    {
        Login.clickEvent(Elements.interactDropdown);
        Login.clickEvent(Elements.blogsPageLink);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Login.clickEvent(Elements.blogsCreateLink);

        Utilities forCreateBlog = new Utilities();
        ArrayList data = forCreateBlog.readExcel("CreateBlog");
        /*data.get(0);
        data.get(1);
        data.get(2);*/




        String blogTitle = String.valueOf(data.get(1));
        String blogBody = String.valueOf(data.get(2));


        Login.sendData(Elements.blogTitle, blogTitle);
        Login.sendData(Elements.blogBody, blogBody);
        Login.clickEvent(Elements.blogPostLink);



    }


    }

 /*   @AfterTest
    public static void screenshot() {
        Utilities.takeSnapShot("CreateBlog");
        ConfigureDriver.get().getDriver().close();
        }
*/








