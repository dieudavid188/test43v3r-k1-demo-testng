package org.example.app;

import org.example.app.pages.DashboardPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest3 {
        WebDriver driver ;
        @Test
        public void f() {

            String baseUrl = "https://www.toolsqa.com/";
            driver = new ChromeDriver();
            driver.navigate().to(baseUrl);
            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.clickon_brand_logo();
        }

        @BeforeMethod
        public void beforeMethod() {
            driver.close();
        }
}
