/*import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;

public class CSVdata {

    //Provide CSV file path. It Is In D: Drive.
    String CSV_PATH="C:\\Users\\sumit\\Desktop\\Automation\\GITHUB\\skorkel\\SeleniumSkorkel\\Resources\\TestData\\UserCSV1.csv";;
    WebDriver driver;




    @Test
    public void csvDataRead() throws IOException{

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String [] csvCell;
        //while loop will be executed till the last line In CSV.
        while ((csvCell = reader.readNext()) != null) {
            System.out.println();
           *//* String FName = csvCell[0];
            String LName = csvCell[1];
            driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
            driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
            driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
            driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(Mob);
            driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(company);
            driver.findElement(By.xpath("//input[@value='Submit']")).click();
            driver.switchTo().alert().accept();*//*
        }
    }
}*/




import com.opencsv.CSVReader;

import java.io.FileReader;

import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class UserCsvReader {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    //User attributes index
    private static final int UserName = 0;
    private static final int Password = 1;

    //String fileName = System.getProperty("user.dir") + "/Resources/TestData/user.csv";

    public static void readCsvFile(String fileName) {

        BufferedReader fileReader = null;

        try {

            //Create a new list of user to be filled by CSV file data
            List userList = new ArrayList();
            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new user object and fill his  data
                    User user = new User(tokens[UserName], tokens[Password]);;
                    userList.add(user);
                }
            }

            //Print the new users list
            for (Object user : userList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {

        String fileName = System.getProperty("user.dir") + "/Resources/TestData/UserCSV1.csv";

        System.out.println("\nRead CSV file:");
        UserCsvReader.readCsvFile(fileName);

    }
}


