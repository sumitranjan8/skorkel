import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

public class HighlighterClass {
    private static WebDriver driver = ConfigureDriver.get().getDriver();

    public void highlighterElement() {

        WebElement dashboardName = driver.findElement(By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]"));
        //Call the highlighterMethod and pass webdriver and WebElement which you want to highlight as arguments.
        highLighterMethod(driver, dashboardName);

    }

    //Creating a custom function
    public void highLighterMethod(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }

    /*public void skorkelTakeScreenShot() throws Exception{

        this.takeSnapShot("Loginsuccess.png") ;

    }*/

    public static void takeSnapShot(String screenshotName) {

        //Convert web driver object to TakeScreenshot
        String fileWithPath = System.getProperty("user.dir") + "/Reports/Screenshots/" + screenshotName;

        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        try {


            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

            File DestFile = new File(fileWithPath);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
