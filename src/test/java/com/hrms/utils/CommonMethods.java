package com.hrms.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {
    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public static void setUp(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                //System.setProperty("webdriver.chrome.driver","C:\\Users\\imark\\IdeaProjects\\JavaBatch9TestNG\\drivers\\chromedriver.exe");
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                //System.setProperty("webdriver.gecko,driver","C:\\Users\\imark\\IdeaProjects\\JavaBatch9TestNG\\drivers\\geckodriver.exe");
                WebDriverManager.chromedriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of browser");
        }

        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    /**
     * This methods is sending text to any textbox
     * @param element
     * @param textToSend
     */
    public void sendText(WebElement element,String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this methods creates an object of WebDriverWait
     * @return
     */
    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver,Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     *
     * this methods will wait till element becomes clickable
     * @param element
     */
    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *
     *Clicking on element when it is clickable
     * @param element
     */
    public static void clickWaitForClickability(WebElement element){
        waitForClickability(element);
        element.click();
    }

    /**
     *
     * this method will wait till element becomes visible
     * @param element
     */
    public static void waitForVisibility(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *
     *Clicking on element when it is visible
     * @param element
     */
    public static void clickWaitForVisibility(WebElement element){
        waitForVisibility(element);
        element.click();
    }

    /**
     *
     * this method check element is displayed
     * @param element
     * @return boolean
     */
    public static boolean displayed(WebElement element){
        waitForVisibility(element);
        return element.isDisplayed();
    }

    /*@AfterMethod(alwaysRun = true)
    public static void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }*/
}
