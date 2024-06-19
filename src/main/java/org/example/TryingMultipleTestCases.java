package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TryingMultipleTestCases {
//    @Test(dataProvider = "dataset")
//    Other way is "by not using extends we can simply write in @Test(dataprovider = "dataset", dataProviderClass = RefrencingPage.class)
//    // That is the file name or class file name which we have mentioned in it.
//    @Test(dataProvider = "create", dataProviderClass = RefrencingPage.class)
//    public void DataProviderMethod(String username, String Password)
//    {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.id("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(Password);
//        driver.findElement(By.id("login-button")).click();
//        driver.close();
//    }


    @Test(dataProvider = "create", dataProviderClass = RefrencingPage.class)
    public void test(String username, String Password)
    {
        System.out.println("username is : " + username);
        System.out.println("Password is : " + Password);
    }
    @Test(dataProvider = "create", dataProviderClass = RefrencingPage.class)
    public void test1(String username, String Password, String number)
    {
        System.out.println("username is : " + username);
        System.out.println("Password is : " + Password);
        System.out.println("Number is : " + number);
    }
    @Test(dataProvider = "create", dataProviderClass = RefrencingPage.class)
    public void test2(String username, String password, String number, String surname)
    {
        System.out.println("username is : " + username);
        System.out.println("Password is : " + password);
        System.out.println("Number is : " + number);
        System.out.println("username is : " + username);
    }
    @Test(dataProvider = "create", dataProviderClass = RefrencingPage.class)
    public void test3(String username, String password, String number, String surname, String fifthvalue)
    {
        System.out.println("username is : " + username);
        System.out.println("Password is : " + password);
        System.out.println("Number is : " + number);
        System.out.println("Number is : " + username);
        System.out.println("Fifth value is : " + fifthvalue);
    }

    @Test(dataProvider = "create", dataProviderClass = RefrencingPage1.class)
    public void test(String name)
    {
        System.out.println("Name is : " + name);
    }
}


