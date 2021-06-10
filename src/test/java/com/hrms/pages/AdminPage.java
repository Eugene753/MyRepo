package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage extends CommonMethods {

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitlesButton;

    @FindBy(id = "menu_admin_Job")
    public WebElement jobButton;

    public AdminPage(){
        PageFactory.initElements(driver,this);
    }

}
