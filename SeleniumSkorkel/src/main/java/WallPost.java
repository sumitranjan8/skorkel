

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


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

        String post = "iewgewewjbew";
        Login.sendData(Elements.postInputField, post);
        Login.clickEvent(Elements.postWallButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebDriver driver = ConfigureDriver.get().getDriver();
//        String postedData = driver.findElement(Elements.wallPost).getText();
//
////        driver.navigate().refresh();
////        postedData = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lstPostUpdates_ctrl0_lblPostDescription\"]")).getText();
//        WebDriverWait wait = new WebDriverWait(driver,20);
//        Boolean element = wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lstPostUpdates_ctrl0_lblPostDescription\"]"), postedData ));
////        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divPostimage")));
//        System.out.println(postedData);
//
//        if (postedData.equals(post)) {
//
//            HighlighterClass.takeSnapShot("WallPost.png");
//        } else {
//
//            HighlighterClass.takeSnapShot("PreWallPost.png");
//        }


    }

    @AfterTest
    public void screenshot() {
        HighlighterClass.takeSnapShot("WallPost.png");
        ConfigureDriver.get().getDriver().close();
    }


}
