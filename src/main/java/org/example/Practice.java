package org.example;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.SelectStrategy;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
@Test
//import org.testng.annotations.Parameters;
public class Practice extends Main {
    public static String browser = "edge";
    public static WebDriver driver;

    public static void main(String[] args) {
        try {
            if (browser.equals("edge")) {
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
            } else if (browser.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }

            // How to handle frames( means, If you are inside a frame and want to switch back to the parent frame, switching from one side to other side of website and then performing operation on it
            driver.manage().window().maximize();
            driver.get("https://extendsclass.com/text.comapre.html");
//          driver.findElement(By.className("cta_button")).click();

//            // How to handle multiple window using Iterator
//            Set<String> windowhandles = driver.getWindowHandles();  // 2 in total
//            Iterator<String> windowiterator = windowhandles.iterator();
//            String parent = windowiterator.next();
//            String child = windowiterator.next();

//            // Parent window to child
//            driver.switchTo().window(child);
//            Thread.sleep(2000);
//            driver.findElement(By.id("UserFirstName-xhD4")).sendKeys("Himanshu");
//            driver.findElement(By.id("UserLastName-F4mU")).sendKeys("Choudhary");
//            driver.switchTo().window(parent);

//            // driver.findElement(By.id(""));
//            WebElement webelement = driver.findElement(By.id(""));
//            Actions a = new Actions(driver);
//            a.contextClick(webelement).perform();


//          // How to handle keyboard events
            // WebElement keyboard = driver.findElement(By.id(""));
//            WebElement actualplace = driver.findElement(By.id(""));
//            Actions a = new Actions(driver);
//            a.keyDown(actualplace, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
//
//            WebElement destination = driver.findElement(By.id(""));
//            a.keyDown(destination, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
//
//


//  Q) Solve this question ?
//            // 1. Switch to frame
//            WebElement frame1 = driver.findElement(By.id(""));
//            driver.switchTo().frame(frame1);
//
//            // 2. Find the number of rows
//            List<WebElement> l = driver.findElements(By.id(""));
//            System.out.println(l.size());
//
//            // 3. Find the number of cols.
//            List<WebElement> c = driver.findElements(By.id(""));
//            System.out.println(c.size());
//
//            // 4. Iterate rows and cols. and get text and print it
//            for (int i = 0; i < l.size(); i++)
//            {
//                for (int j = 0; j < c.size(); j++)
//                {
//                    // This will return all the <href> link from l and c
//                    driver.findElement(By.id("")).getAttribute("href");
//                    // This will return all the Text content from the l and c
//                    driver.findElement(By.id("")).getText();
//                }
//            }

//keyDown() Method
//Purpose: Simulates pressing a key down and holding it.
//Usage: This is typically used when you want to simulate a key being held down while performing another action, such as pressing multiple keys together (e.g., Ctrl+C for copy).

//Actions action = new Actions(driver);
//action.keyDown(Keys.CONTROL).perform();
//keyUp() Method
//Purpose: Simulates releasing a key that was previously pressed down.
//Usage: This is used to release a key that was held down, often following a keyDown() action to complete a composite action.

//Actions action = new Actions(driver);
//action.keyUp(Keys.CONTROL).perform();



            // driver.switchTo().frame(0);
            // Put the id or the integer value of this side of frame so, that we can easily switch to that frame.
//          // driver.switchTo().frame("iframeResult");
//          // driver.findElement(By.xpath("/html/body/button")).click();
//          // So, if by any chance we have an alert we will accept it by this method
//          // Alert alert = driver.switchTo().alert();
//          // Accept the alert
//          // alert.accept();
//          // else for dismissing the alert
//          // alert.dismiss();




//            // This is way of handling auto suggestive dropdown
//            WebElement fruit = driver.findElement(By.xpath("//*[@id=\"fruit\"]"));
//            fruit.sendKeys("Apple");
//            fruit.sendKeys(Keys.ENTER);
//            Thread.sleep(2000);
//            s.selectByVisibleText("Apple");
//            WebElement radio = driver.findElement(By.xpath("//*[@id=\"s0-1-0-48-1-3-5-14-0[2]-10-@match-media-0-@ebay-carousel-list\"]/li[3]/a/h3"));
//            Actions a = new Actions(driver);
//            a.moveToElement(radio);
//            a.perform();


//            List<WebElement> l = driver.findElements(new By.ByTagName("a"));
//            WebElement l1 = driver.findElement(By.tagName("a"));
//            System.out.println(l1.getAttribute("href"));
//            System.out.println(l);
//            System.out.println(l.size());
//            System.out.println(l1);
//            for (int i = 0; i < l.size(); i++)
//            {
//                System.out.println(l.get(i).getAttribute("href"));
//            }
        }
        catch (Exception e)
        {
            System.out.println("error : " + e);
            e.printStackTrace();
            // driver.quit();
        }
    }
}