import org.openqa.selenium.By;

public class Elements {

//    Login page Elements:

    final static By UserName = By.id("UserName");
    final static By Password = By.id("Password");
    final static By btn_login = By.xpath("//*[@id='form2']//div[@class='btn btn-primary login-popup']");
    final static By btn_loginPopup = By.id("Login1_button");
    final static By dashboard_name = By.xpath("//*[@id=\"ctl00_lblDashBoardName\"]");
    final static By loginErrorMessage = By.xpath("//*[@id=\"FailureText\"]");

//    Dashboard Elements:

    final static By postInputField = By.id("txtPostUpdate");
    final static By postWallButton = By.id("lnkPostUpdate");
    final static By wallPost = By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_lstPostUpdates_ctrl0_lblPostDescription\"]");

//    CreateBlog Elements:
    final static By interactDropdown = By.xpath("//*[@id=\"drodown_interact\"]");
    final static By blogsPageLink = By.xpath("//*[@id=\"ctl00_myli_AllBlogs\"]");
    final static By blogsCreateLink = By.xpath("//*[@id=\"ctl00_blogWrite\"]/a/div");
    final static By blogTitle = By.xpath("//*[@id=\"txtTitle\"]");
    final static By blogBody = By.xpath("//*[@id=\"CKDescription\"]");
    final static By blogPostLink = By.xpath("//*[@id=\"lnkSubmitBlog\"]");

}

