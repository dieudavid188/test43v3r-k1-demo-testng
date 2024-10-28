package org.example.app.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DashboardPage {
    WebDriver driver;

    WebElement navbar_brand_logo = driver.findElement(By.xpath("//a[contains(@class,'navbar__brand')]"));
    WebElement navbar_tutorial_menu = driver.findElement(By.xpath("//a[contains(@class,'navbar__tutorial-menu')]"));
    WebElement navbar_links_home = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Home']"));
    WebElement navbar_links_seleniumTraining = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Selenium Training']"));
    WebElement navbar_links_demoSite = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='Demo Site']"));
    WebElement navbar_links_about = driver.findElement(By.xpath("//div[contains(@class,'navbar__links')]//ul/li/a[text()='About']"));
    WebElement navbar_links_search = driver.findElement(By.xpath("//div[contains(@class,'navbar__links-and-search')]//div[contains(@class,'navbar__search')]"));

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickon_brand_logo() {
        navbar_brand_logo.click();
    }
}
