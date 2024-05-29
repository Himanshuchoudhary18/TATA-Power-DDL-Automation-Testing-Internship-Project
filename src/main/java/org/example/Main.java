package org.example;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.testng.annotations.Parameters;
public class Main {
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
                    // System.setProperty("webdriver.chrome.driver", "D:\\CS STUDY MATERIAL\\selenium webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
                    driver.manage().window().maximize();
                    driver.get("https://www.tatapower-ddl.com/");

                    // To handle any advertisement / any pop - up
                    Thread.sleep(2000);
                    driver.findElement(By.id("cboxClose")).click();

//                  driver.get("https://www.tatapower-ddl.com/myconnection/index.aspx");
                    driver.findElement(By.id("connectionRange1")).click();
                    driver.findElement(By.id("btnDomestic_E")).click();

                    /* STEP 2 */
                    // For, Verifying the OTP and phone number
                    // Wait for the phone number input field to be present
                    driver.findElement(By.id("btnNewConnection_E")).click();
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement phoneNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("phoneNumberField")));

                    // Input the phone number in the phone number field
                    String phoneNumber = "1234567890";
                    phoneNumberField.clear();
                    phoneNumberField.sendKeys(phoneNumber);
                    System.out.println("Entered phone number: " + phoneNumber);

                    // Submit the phone number to trigger OTP sending (clicking the submit button)
                    WebElement submitButton = driver.findElement(By.id("submitPhoneNumberButton"));
                    submitButton.click();

                    // Wait for the OTP input field
                    WebElement otpField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("otpField")));

                    // Retrieve the OTP (this would typically involve reading from an external service, SMS, or email)
                    // For demonstration purposes, let's assume the OTP is manually retrieved and entered
                    String otp = "123456"; // Replace this with the actual OTP retrieval mechanism
                    otpField.clear();
                    otpField.sendKeys(otp);
                    System.out.println("Entered OTP: " + otp);

                    // Submit the OTP (clicking the verify button)
                    WebElement verifyButton = driver.findElement(By.id("verifyOtpButton"));
                    verifyButton.click();

                    // Wait for the verification result (this could be a success message or an error message)
                    WebElement resultMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultMessage")));

                    // Verify the result message
                    String expectedSuccessMessage = "Verification successful!";
                    if (expectedSuccessMessage.equals(resultMessage.getText())) {
                        System.out.println("OTP verification successful.");
                    } else {
                        System.out.println("OTP verification failed. Message: " + resultMessage.getText());
                    }

                    /* STEP - 3 */
                    // Here, we will fill all the details in the form
                    driver.findElement(By.id("panelPersonalDetails")).click();
                    // Clicking on the dropdown box
                    WebElement dd = driver.findElement(By.id("ddlApplicationFor"));
                    Select s = new Select(dd);
                    s.selectByValue("0");
                    // OR //
                    // s.selectByIndex(1);
                    // OR //
                    // The text that is visible to the user which is b/w the tags
                    // s.selectByVisibleText("Applicant");

                    /* STEP - 4 */
                    // Here, we will repeat the same above steps for drop down menu for Title
                    WebElement dd2 = driver.findElement(By.id("ddlTitle"));
                    Select s1 = new Select(dd);
                    s1.selectByValue("Mr.");

                    /* STEP - 5 */
                    // Here, we will fill the first name of the user
                    driver.findElement(By.id("txtFirstName")).sendKeys("Himanshu");

                    /* STEP - 6 */
                    driver.findElement(By.id("txtMiddleName")).sendKeys("");

                    /* STEP - 7 */
                    driver.findElement(By.id("txtLastName")).sendKeys("Choudhary");

                    /* STEP - 8 */
                    WebElement dd3 = driver.findElement(By.id("ddlRelationship"));
                    Select s2 = new Select(dd3);
                    s2.selectByVisibleText("Son Of");


                    /* STEP - 9 */
                    driver.findElement(By.id("txtRelationshipName")).sendKeys("Xyzkqj kumar");

                    /* STEP - 10 */
                    driver.findElement(By.id("txtAuthSignatory")).sendKeys("Xyzkqj singh");

                    /* STEP - 11 */
                    // Here, we have to automate the calendar for DOB
                    WebElement dateInputField = driver.findElement(By.id("txtDob"));

                    // Click on the input field to trigger the calendar
                    dateInputField.click();

                    // Locate and click on the specific date in the calendar
                    WebElement desiredDate = driver.findElement(By.xpath("//td[@class='datepicker-day' and text()='25']"));
                    desiredDate.click();
                    // OR //
                    // we can use JavaScript to set the date directly
                    // ((JavascriptExecutor)driver).executeScript("arguments[0].value='2024-05-25';", dateInputField);

                    /* STEP - 12 */
                    // Here, we have to choose the Relationship from the Drop Down box
                    WebElement dd4 = driver.findElement(By.id("ddlRelationship"));
                    Select s3 = new Select(dd4);
                    s3.selectByVisibleText("Male");


                    /* STEP - 13 */
                    // This is for automating the phone number column
                    driver.findElement(By.id("txtMobileNo")).sendKeys("7669966400");

                    /* STEP - 14 */
                    driver.findElement(By.id("txtLandlineNo")).sendKeys("7669966400");


                    /* STEP - 15 */
                    WebElement dd5 = driver.findElement(By.id("ddlOccupation"));
                    Select s4 = new Select(dd5);
                    s4.selectByIndex(8);       // under-graduate will be selected from drop - down menu


                    /* STEP - 16 */
                    driver.findElement(By.id("txtPreviousOwnerName")).sendKeys("Mr. Hansraj Singh");

                    /* STEP - 17 */
                    WebElement dd6 = driver.findElement(By.id("ddlOccupation"));
                    Select s5 = new Select(dd6);
                    s5.selectByIndex(2);

                    /* STEP - 18 */
                    driver.findElement(By.className("form-control")).sendKeys("Mrs. Hanshika Singh");

                    /* STEP - 19 */
                    driver.findElement(By.id("txtEmailId")).sendKeys("himanshuchoudhsary1@gmail.com");

                    /* STEP - 20 */
                    driver.findElement(By.id("btnVerifyEmailID")).click();

                    /* STEP - 21 */


                    driver.manage().window().minimize();
                }
                catch (Exception e)
                {
                    driver.quit();
                    e.printStackTrace();
                }
     }
}