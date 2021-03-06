import org.openqa.selenium.WebDriver;

public class BusinessLogic {

    private WebDriver driver = ConfigureDriver.get().getDriver();


    public void isLoggedIn() {
        String dashboard = ("Home");
        String dashboardName;
        String errorMessage;

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        try {
            dashboardName = Login.elementFinder(Elements.dashboard_name).getText();

        } catch (Exception e) {
            e.getMessage();
            dashboardName = null;
        }

        if (dashboard.equals(dashboardName)) {
            System.out.println("......User Logined Successfully..........");
            Utilities h = new Utilities();
            h.highlighterElement();
            System.out.println(".....Element Highlighted...........");
            Utilities.takeSnapShot("loginSuccess.png");
        } else {
            System.out.println(".........Login Failed.........");
            Utilities.takeSnapShot("loginFailed.png");
            errorMessage = Login.elementFinder(Elements.loginErrorMessage).getText();
            System.out.println("... Unable to Login: " + errorMessage);

        }


    }

}
