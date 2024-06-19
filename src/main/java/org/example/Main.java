package org.example;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.*;
import java.util.concurrent.TimeoutException;

//import org.testng.annotations.Parameters;

public class Main {
    WebDriver driver;
    String browser = "edge";
    WebDriverWait wait;
    JavascriptExecutor js;

    @Parameters({"browser"})
    @Test(priority = 1)
    public void StartupApplication() {
        try {
            if (browser.equalsIgnoreCase("edge")) {
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            // System.setProperty("webdriver.chrome.driver", "D:\\CS STUDY MATERIAL\\selenium webdriver\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test(priority = 2)
    public void visitWebPage() {
        try {
            driver.get("https://www.tatapower-ddl.com/");

            // To handle any advertisement / any pop - up
            wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Wait for the pop-up to appear and close it
            try {
                WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cboxClose")));
                closeButton.click();
                System.out.println("Pop-up closed successfully.");
            } catch (Exception e) {
                System.out.println("Pop-up not found or already closed.");
            }
            driver.get("https://www.tatapower-ddl.com/myconnection/index.aspx");
            driver.findElement(By.id("connectionRange1")).click();
            driver.findElement(By.id("btnDomestic_E")).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void PhoneNumberVerification() throws UnhandledAlertException {
        try {
            // For, Verifying the OTP and phone number
            driver.findElement(By.id("btnNewConnection_E")).click();
            // driver.findElement(By.id("txtMobileNo")).click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Input the phone number in the phone number field
            WebElement phoneNumberField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtMobileNo")));
            String phoneNumber = "7669966400";
            Scanner scanner;
            if (phoneNumber.length() == 10) {
                phoneNumberField.clear();
                phoneNumberField.sendKeys(phoneNumber);
                System.out.println("Entered phone number: " + phoneNumber);
                System.out.println("Valid number");
                driver.findElement(By.id("btnLoginContinue")).click();

            } else {
                System.out.println("Invalid Phone number");
            }
            System.out.println("Pause..... Press OTP manually to continue...");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlApplicationFor")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 4, dataProviderClass = RefrencingPage.class, dataProvider = "create")
    public void Details(String firstname, String lastname, String email, String phonenumber) throws InterruptedException {
        /* STEP - 3 */
        // Here, we will fill all the details in the form
        // driver.findElement(By.id("panelPersonalDetails")).click();
        // Clicking on the dropdown box
        WebElement dd = driver.findElement(By.id("ddlApplicationFor"));
        Select s = new Select(dd);
        s.selectByValue("0");

        /* STEP - 4 */
        // Here, we will repeat the same above steps for drop down menu for Title
        WebElement dd2 = driver.findElement(By.id("ddlTitle"));
        Select s1 = new Select(dd2);
        s1.selectByValue("Mr.");

        /* STEP - 5 */
        // Here, we will fill the first name of the user
        driver.findElement(By.id("txtFirstName")).sendKeys(firstname);

        /* STEP - 6 */
        driver.findElement(By.id("txtMiddleName")).sendKeys("");

        /* STEP - 7 */
        driver.findElement(By.id("txtLastName")).sendKeys(lastname);

        /* STEP - 8 */
        WebElement dd3 = driver.findElement(By.id("ddlRelationship"));
        Select s2 = new Select(dd3);
        s2.selectByVisibleText("Son Of");


        /* STEP - 9 */
        driver.findElement(By.id("txtRelationshipName")).sendKeys("Manoj Kr. Choudhary");

        /* STEP - 10 */
        driver.findElement(By.id("txtAuthSignatory")).sendKeys("Manoj Kr. Choudhary");

        /* STEP - 11 */
        // Here, we have to automate the calendar for DOB
        js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('txtDob').value='2002-08-18';");


        /* STEP - 12 */
        // Here, we have to choose the Relationship from the Drop-Down box
        WebElement dd4 = driver.findElement(By.id("ddlGender"));
        Select s3 = new Select(dd4);
        s3.selectByVisibleText("Male");


        /* STEP - 13 */
        // This is for automating the phone number column
        driver.findElement(By.id("txtMobileNo")).sendKeys("7669966400");

        /* STEP - 14 */
        driver.findElement(By.id("txtLandlineNo")).sendKeys(phonenumber);


        /* STEP - 15 */
        WebElement dd5 = driver.findElement(By.id("ddlOccupation"));
        Select s4 = new Select(dd5);
        s4.selectByIndex(8);       // under-graduate will be selected from drop - down menu


        /* STEP - 16 */
        driver.findElement(By.id("txtPreviousOwnerName")).sendKeys("Mr. Hansraj Singh");

        /* STEP - 17 */
        WebElement dd6 = driver.findElement(By.id("ddlPreviousOwnerRelationship"));
        Select s5 = new Select(dd6);
        s5.selectByValue("SO");

        /* STEP - 18 */
        driver.findElement(By.id("txtPreviousOwnerRelationshipName")).sendKeys("Mrs. Hanshika Singh");

        /* STEP - 19 */
        driver.findElement(By.id("txtEmailId")).sendKeys(email);

        /* STEP - 20 */
        driver.findElement(By.id("btnVerifyEmailID")).click();

        System.out.println("Email OTP Generated");

        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Type OTP....");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnValidateOTP"))).click();

        System.out.println("OTP verified");
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();

        System.out.println("Personal details saved successfully");
        driver.findElement(By.id("btnSavePersonalData")).click();

        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
    }

    @Test(priority = 5, dataProvider = "create1", dataProviderClass = RefrencingPage.class)
    public void ConnectioDetails(String sanctionload, String PAN, String GSTIN, String Bank_Ac_No) {
        try {
            // Now, for the "Connection Details"
            WebElement dd7 = driver.findElement(By.id("ddlCategoryApplied"));
            Select s6 = new Select(dd7);
            s6.selectByValue("EDOM~E-DOMESTIC");

            /* STEP - 27 */
            WebElement dd8 = driver.findElement(By.id("ddlConnectionPurpose"));
            Select s7 = new Select(dd8);
            s7.selectByValue("Residential");

            /* STEP - 28 */
            driver.findElement(By.id("txtKwSanctionedLoad")).sendKeys(sanctionload);

            /* STEP - 29 */
//                    WebElement dd9 = driver.findElement(By.id("ddlMeterType"));
//                    Select s9 = new Select(dd9);
//                    s9.selectByValue("1");

            /* STEP - 30 */
            WebElement dd10 = driver.findElement(By.id("ddlConnectionDuration"));
            Select s10 = new Select(dd10);
            s10.selectByValue("P");

            /* STEP - 30 */
            driver.findElement(By.id("searchradioSubsidyYes")).click();

            /* STEP - 31 */
            WebElement dd11 = driver.findElement(By.id("ddlClassification"));
            Select s11 = new Select(dd11);
            s11.selectByValue("PRVT");

            /* STEP - 32 */
            WebElement dd12 = driver.findElement(By.id("ddlConnectionType"));
            Select s12 = new Select(dd12);
            s12.selectByValue("POSTPAID");


            /* STEP - 33 */
            WebElement dd13 = driver.findElement(By.id("ddlAccomodationType"));
            Select s13 = new Select(dd13);
            s13.selectByValue("02");

            /* STEP - 34 */
            WebElement dd14 = driver.findElement(By.id("ddlMeterProvidedby"));
            Select s14 = new Select(dd14);
            s14.selectByValue("TPDDL");

            /* STEP - 35 */
            driver.findElement(By.id("txtPanNo")).sendKeys(PAN);

            /* STEP - 36 */
            driver.findElement(By.id("txtGstInNo")).sendKeys(GSTIN);

            /* STEP - 37 */
            js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementById('txtGstValidityEndDate').value='2024-05-30';");


            /* STEP - 38 */
            driver.findElement(By.id("txtBankAcNo")).sendKeys(Bank_Ac_No);

            /* STEP - 39 */
            driver.findElement(By.id("chkElcb")).click();
            driver.findElement(By.id("chkWiring")).click();
            driver.findElement(By.id("chkEarthing")).click();

            /* STEP - 40 */
            WebElement dd15 = driver.findElement(By.id("ddlIsEBillRequired"));
            Select s15 = new Select(dd15);
            s15.selectByValue("1");

            /* STEP - 41 */
            WebElement dd16 = driver.findElement(By.id("ddlIsBillWhatsapp"));
            Select s16 = new Select(dd16);
            s16.selectByValue("1");


            /* STEP - 42 */
            WebElement dd17 = driver.findElement(By.id("ddlIsServiceRequired"));
            Select s17 = new Select(dd17);
            s17.selectByValue("NA");

            /* STEP - 43 */
            driver.findElement(By.id("btnSaveConnectionData")).click();

            /* STEP - 44 */
            System.out.println("Pause for alert handling....");
            Alert alert = driver.switchTo().alert();
            alert.accept();

            System.out.print("Connection Details saved successfully");

        } catch (Exception e) {
            // driver.quit();
            e.printStackTrace();
        }
    }
    @Test(priority = 6, dataProviderClass = RefrencingPage.class, dataProvider = "create2")
    public void SupplyAddressDetails(String HouseNo, String number, String address, String BuildingName) throws InterruptedException {
        // Pin-code
        // Manually handle Pincode(110006) & Area(BADA HINDU RAO)

        // Locality
        WebElement dd18 = driver.findElement(By.id("ddlLocality"));
        Select s18 = new Select(dd18);
        s18.selectByValue("PUL BANGASH");

        Thread.sleep(1000);
        WebElement dd19 = driver.findElement(By.id("ddlSociety"));
        Select s19  = new Select(dd19);
        s19.selectByVisibleText("NAYA MOHALLA");


        Thread.sleep(1000);
        WebElement dd20 = driver.findElement(By.id("connectionObject"));
        Select s20  = new Select(dd20);
        s20.selectByVisibleText("Block->B-5");

        driver.findElement(By.id("txtStreetNo")).sendKeys(HouseNo);

        Thread.sleep(1000);
        WebElement dd21 = driver.findElement(By.id("ddlHouseDetails"));
        Select s21  = new Select(dd21);
        s21.selectByVisibleText("Flat No");

        WebElement dd22 = driver.findElement(By.id("ddlPremisesDetails"));
        Select s22  = new Select(dd22);
        s22.selectByValue("Room No");


        driver.findElement(By.id("txtHouseDetails")).sendKeys(HouseNo);

        driver.findElement(By.id("txtPremiseNumber")).sendKeys(HouseNo);

        driver.findElement(By.id("txtUPICNo")).sendKeys(number);

        driver.findElement(By.id("txtLandmark")).sendKeys(address);

        driver.findElement(By.id("txtKhasraNo")).sendKeys(number);

        WebElement dd23 = driver.findElement(By.id("ddlCommunicationAdd"));
        Select s23  = new Select(dd23);
        s23.selectByValue("Same");

        driver.findElement(By.id("txtPlotNo")).sendKeys(number);

        driver.findElement(By.id("txtBuildingName")).sendKeys(BuildingName);

        driver.findElement(By.id("txtAdditionalAddress")).sendKeys(BuildingName);

        Thread.sleep(3000);
        // Total No. of Floors in Building(1), Applied Floor(GROUND) and Premise portion(WEST) have to be done manually
        WebElement dd24 = driver.findElement(By.id("ddlTotalArea"));
        Select s24  = new Select(dd24);
        s24.selectByValue("sqm");


        Thread.sleep(2000);
        driver.findElement(By.id("txtAreaInSqMeter")).sendKeys("1200");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"btnSaveSupplyAddressData\"]")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test(priority = 7, dataProvider = "create3", dataProviderClass = RefrencingPage.class)
    public void DocumentDetails(String CANumber, String AadharNumber) throws InterruptedException {
        System.out.println("Type Pole Number or CA Number.....");
        Thread.sleep(2000);
        // Either Pole Number or CA number
        driver.findElement(By.id("txtNeighbouringCaNo")).sendKeys(CANumber);
        Thread.sleep(2000);



        WebElement dd25 = driver.findElement(By.id("ddlIsExistTempConn"));
        Select s25  = new Select(dd25);
        s25.selectByVisibleText("Yes");
        Thread.sleep(1000);


        driver.findElement(By.id("txtCaNo")).sendKeys(CANumber);
        Thread.sleep(1000);


        WebElement dd26 = driver.findElement(By.id("ddlIdProof"));
        Select s26  = new Select(dd26);
        s26.selectByValue("acd");
        Thread.sleep(1000);


        driver.findElement(By.id("txtIdNo")).sendKeys(AadharNumber);
        Thread.sleep(1000);


        // File Upload (for ex- Aadhar card)
        WebElement file = driver.findElement(By.id("idProofFile"));
        String filepath = "D:\\CS STUDY MATERIAL\\Tata Power DDL Automation\\All Uploading Files\\aadhar.pdf";
        file.sendKeys(filepath);

        System.out.println("File Uploaded Successfully");
        // Wait for file to get uploaded properly
        Thread.sleep(2000);

        WebElement dd27 = driver.findElement(By.id("ddlOwnershipStatus"));
        Select s27  = new Select(dd27);
        s27.selectByVisibleText("Owner");

        driver.findElement(By.id("searchradioFloorNo")).click();

        // Manually uplaod Passport Photograph and signature
        WebElement dd28 = driver.findElement(By.id("ddlOwnershipProof"));
        Select s28  = new Select(dd28);
        s28.selectByValue("gsc");

        driver.findElement(By.id("txtNoOfPages")).sendKeys("18");

        WebElement file1 = driver.findElement(By.id("ownershipProofFile"));
        String filepath1 = "D:\\CS STUDY MATERIAL\\Tata Power DDL Automation\\All Uploading Files\\aadhar.pdf";
        file1.sendKeys(filepath1);
        System.out.println("File Uploaded Successfully");
        // Wait for file to get uploaded properly
        Thread.sleep(2000);

        WebElement file2 = driver.findElement(By.id("miscellaneousFile"));
        String filepath2 = "D:\\CS STUDY MATERIAL\\Tata Power DDL Automation\\All Uploading Files\\aadhar.pdf";
        file2.sendKeys(filepath2);
        System.out.println("Miscellaneous File Uploaded Successfully");
        // Wait for file to get uploaded properly
        Thread.sleep(2000);

        driver.findElement(By.id("searchRadioSqmNo")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("searchRadioTotalSqmNo")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("btnSaveDocumentDetails")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        System.out.println("Form submitted successfully");
    }
}
