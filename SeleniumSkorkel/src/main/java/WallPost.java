import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class WallPost {



    @Test(priority = 2)
    public void createPost() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter PostData:  ");
        String postData = myObj.nextLine();
        myObj.close();

        Login.sendData(Elements.postInputField, postData);
        Login.clickEvent(Elements.postWallButton);


    }


}













