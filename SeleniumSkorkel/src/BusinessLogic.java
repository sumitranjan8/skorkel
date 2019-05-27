import org.openqa.selenium.WebDriver;

public class BusinessLogic {

    private WebDriver driver = ConfigureDriver.get().getDriver();

    public void isLoggedIn(){
        String dashboard = ("Home");
        String dashboardName;
        String errorMessage;

        try {
            dashboardName = Login.elementFinder(Elements.dashboard_name).getText();
        }catch (Exception e) {
            e.getMessage();
            dashboardName = null;
        }
        if (dashboard.equals(dashboardName)){
            System.out.println("......User Logined Successfully..........");
            HighlighterClass h = new HighlighterClass();
            h.highlighterElement();
            System.out.println(".....Element Highlighted...........");
            HighlighterClass.takeSnapShot("loginSuccess.png");
        }else{
            System.out.println(".........Login Failed.........");
            HighlighterClass.takeSnapShot("loginFailed.png");
            errorMessage = Login.elementFinder(Elements.loginErrorMessage).getText();
            System.out.println("... Unable to Login: "+errorMessage);

        }

    }

}
