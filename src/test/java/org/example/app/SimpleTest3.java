package org.example.app;

import org.example.app.pages.DashboardPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class SimpleTest3 {
    private WebDriver driver;
    String baseUrl = "https://demowebshop.tricentis.com/login";
    @BeforeMethod
    public void setUp() {
        // Sử dụng WebDriverManager thay vì khởi tạo trực tiếp
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Verify successful login and account display")
    public void submitformSuccess() {
        driver.navigate().to(baseUrl);
        // Kiểm tra driver trước khi truyền vào DashboardPage
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.login("nashtechhoang@gmail.com","123321456");
        Assert.assertTrue(dashboardPage.verifyAccountLoginSuccess());
    }

    @Test(description ="Verify failed login")
    public void submitFormFail(){
        driver.navigate().to(baseUrl);
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.login("nashtechhoang@gmail.com"," ");
        Assert.assertTrue(dashboardPage.verifyAccountLoginfail());
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanTextUnsuccessful()), "Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liTextCredentialsIncorrect()), "The credentials provided are incorrect");
    }

    @Test(description ="Verify field blank")
    public void submitFieldBlank(){
        driver.navigate().to(baseUrl);
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.login(" "," ");;
        Assert.assertTrue(dashboardPage.verifyAccountLoginfail());
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanTextUnsuccessful()), "Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liTextCredentialsIncorrect()), "No customer account found");
    }

    @Test(description ="Verify Tab is working")
    public void verifyTabIsWorking(){
        driver.navigate().to(baseUrl);
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginByTab();
        Assert.assertEquals(dashboardPage.inputRememberme(), dashboardPage.focusedElement());
    }

    @Test(description ="Verify Enter is working")
    public void verifyEnterIsWorking(){
        driver.navigate().to(baseUrl);
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginByEnter();
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanTextUnsuccessful()), "Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liTextCredentialsIncorrect()), "No customer account found");
    }

    @Test(description ="")
    public void verifyEnterIs(){
        driver.navigate().to(baseUrl);
        if (driver == null) {
            throw new IllegalStateException("WebDriver chưa được khởi tạo!");
        }
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.loginByEnter();
        Assert.assertEquals(dashboardPage.getText(dashboardPage.spanTextUnsuccessful()), "Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(dashboardPage.getText(dashboardPage.liTextCredentialsIncorrect()), "No customer account found");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
