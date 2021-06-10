package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//div[@id='divLogo']/img")
    public WebElement syntaxLogo;

    @FindBy(id = "txtUsername")
    public WebElement userNameBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    @FindBy(id="spanMessage")
    public WebElement spanMessage;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIMBTN;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeList;

    @FindBy(id="empsearch_id")
    public WebElement IdBox;

    @FindBy(id = "searchBtn")
    public WebElement searchBtn;

    public void login(String username,String password){
        sendText(userNameBox, username);
        sendText(passwordBox,password);
        clickWaitForClickability(loginBtn);

    }

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
}
