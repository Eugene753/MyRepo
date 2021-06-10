package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class JobTitleList extends CommonMethods {

    @FindBy(id = "btnAdd")
    public WebElement addBtnJobTitle;

    public JobTitleList(){
        PageFactory.initElements(driver,this);
    }

}
