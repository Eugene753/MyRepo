package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class AddJobTitle extends CommonMethods {

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement jobTitleField;

    @FindBy(id = "jobTitle_jobDescription")
    public WebElement jobDescriptionField;

    @FindBy(xpath = "//input[@id='jobTitle_jobSpec']")
    public WebElement jobSpecificationField;

    @FindBy(id = "jobTitle_note")
    public WebElement noteField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    public AddJobTitle(){
        PageFactory.initElements(driver,this);
    }
}
