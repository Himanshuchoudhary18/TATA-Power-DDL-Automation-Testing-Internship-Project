# TATA-Power-DDL-Automation-Testing-Internship-Project

This repository contains a Java program that automates the process of filling out a new connection form on the Tata Power-DDL website using Selenium WebDriver. The program is designed to interact with various web elements, such as text fields, drop-down menus, and buttons, to simulate a user filling out the form step by step.

#** Prerequisites**
Before running the program, ensure you have the following installed:

**Java Development Kit (JDK) 8 or later
Apache Maven
A modern web browser (Chrome, Edge, Firefox, or Safari)
Internet connection
Setup
Clone the repository:

sh

Copy code
git clone https://github.com/Himanshuchoudhary18/TATA-Power-DDL-Automation-Testing-Internship-Project.git
cd selenium-tata-power-automation
Install dependencies:
This project uses WebDriverManager for managing browser drivers. Ensure you have Maven installed, then run:

sh
Copy code
mvn clean install
Configure the browser:
By default, the program is set to use Edge browser. You can change the browser by modifying the browser variable in the Main class:**

java
Copy code
public static String browser = "edge"; // Change to "chrome", "firefox", or "safari" as needed
Running the Program
To run the program, execute the following command in the project directory:

sh
Copy code
mvn exec:java -Dexec.mainClass="org.example.Main"
The program will launch the specified web browser, navigate to the Tata Power-DDL website, and perform the following steps:

1. Handle any advertisement or pop-up.
2. Navigate to the new connection form.
3. Verify the phone number and OTP.
4. Fill out personal details and other required information.
5. Submit the form.
6. Detailed Steps
Step 1: Handle Advertisement/Pop-up
Please wait for the advertisement pop-up and close it.

Step 2: Navigate to the New Connection Form
Click on the appropriate buttons to navigate to the new connection form.

Step 3: Verify Phone Number and OTP
Enter the phone number.
Submit the phone number to receive an OTP.
Enter the OTP and verify it.
Step 4: Fill Personal Details
Fill out the form with personal details such as name, relationship, date of birth, gender, phone number, email, and occupation.

Step 5: Submit the Form
Submit the form and wait for the confirmation.

Notes
The program includes placeholder values for the phone number and OTP. These should be replaced with actual values or integrated with a service that retrieves them dynamically.
Error handling is included to ensure the browser closes properly in case of an exception.
Contributing
Contributions are welcome! Please create a new branch for your feature or bug fix and submit a pull request.

License
This project is licensed under the MIT License. See the LICENSE file for details.

Contact
If you have any issues or questions, please create an issue in the repository or contact the maintainer at himanshuchoudhsary1@gmail.com.

**Disclaimer**: 
This automation script is intended for educational purposes only. Ensure you have permission to automate interactions with any website before doing so. Use responsibly.
