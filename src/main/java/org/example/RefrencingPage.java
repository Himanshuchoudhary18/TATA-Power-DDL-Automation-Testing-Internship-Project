package org.example;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class RefrencingPage {
    @DataProvider (name = "create")
    public Object[][] dataset()
    {
        return new Object[][]{{"Himanshu", "Choudhary", "himanshuchoudhsary1@gmail.com", "7669966400"}};
    }
    @DataProvider(name = "create1")
    public Object[][] dataset1()
    {
        return new Object[][] {{"18", "CSTPC8817Q", "GSTPC8817Q", "4278321021244342"}};
    }

    @DataProvider(name = "create2")
    public Object[][] dataset2()
    {
        return new Object[][] {{"Gate no. 4", "1234567890", "G-507/Surya-Vihar Apartments/Sector-21/Delhi", "Surya Vihar Apartments"}};
    }
    @DataProvider(name = "create3")
    public Object[][] dataset3()
    {
        return new Object[][] {{"60024895231", "424876409460"}};
    }
}

