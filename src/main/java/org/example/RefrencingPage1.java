package org.example;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class RefrencingPage1 {
    @DataProvider(name = "create")
    public Object[][] test(Method m) {
        Object[][] testdata = null;
        if (m.getName().equals("test")) {
            testdata = new Object[][]{{"Rohit Sharma"}};
        }
        return testdata;
    }
}
