package org.example.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import dev.failsafe.internal.util.Assert;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver không được null!");
        }
        this.driver = driver;
    }
    // WebElement navbar_brand_logo = driver.findElement(By.xpath("//a[contains(@class,'navbar__brand')]"));
    // WebElement navbar_tutorial_menu = driver.findElement(By.xpath("//a[contains(@class,'navbar__tutorial-menu')]"));
    // WebElement navbar_links_home = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Home']"));
    // WebElement navbar_links_seleniumTraining = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Selenium Training']"));
    // WebElement navbar_links_demoSite = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Demo Site']"));
    // WebElement navbar_links_about = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='About']"));
    // WebElement navbar_links_search = driver.findElement(By.xpath("//div[contains(@class,'navbar__links-and-search')]//div[contains(@class,'navbar__search')]"));

    private WebElement getLoginEmail() {
        return driver.findElement(By.xpath("//input[@id='Email']"));
    }

    private WebElement getLoginPassword() {
        return driver.findElement(By.xpath("//input[@id='Password']"));
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
    }

    private WebElement getAccountlogin(){
        return driver.findElement(By.xpath("//div[@class='header-links']/ul/li/a[@class='account']"));
    }

    public WebElement divTextUnsuccessful(){
        return driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
    }

    public WebElement spanTextUnsuccessful(){
        return driver.findElement(By.xpath("//div[@class='validation-summary-errors']/span"));
    }

    public WebElement liTextCredentialsIncorrect(){
        return driver.findElement(By.xpath("//div[@class='validation-summary-errors']/ul/li"));
    }

    public WebElement inputRememberme(){
        return driver.findElement(By.xpath("//input[@id='RememberMe']"));
    }

    public WebElement focusedElement(){
        return driver.switchTo().activeElement();
    }

    public void clickon_brand_logo() {
        // navbar_brand_logo.click();
    }

    public void login(String email, String password) {
        getLoginEmail().sendKeys(email);
        getLoginPassword().sendKeys(password);
        getLoginButton().click();
    }

    public void loginByTab() {
        getLoginEmail().sendKeys(Keys.TAB);
        getLoginPassword().sendKeys(Keys.TAB);
    }

    public void loginByEnter() {
        getLoginEmail().sendKeys(Keys.ENTER);
    }

    public boolean verifyAccountLoginSuccess(){
        return getAccountlogin().isDisplayed();
    }

    public boolean verifyAccountLoginfail(){
        return divTextUnsuccessful().isDisplayed();
    }

    public String getText(WebElement element){
        return element.getText();
    }
}
