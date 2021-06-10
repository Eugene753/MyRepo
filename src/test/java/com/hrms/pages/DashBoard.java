package com.hrms.pages;

import com.hrms.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard extends CommonMethods {

    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement PIMButton;

    @FindBy(id = "menu_leave_viewLeaveModule")
    public WebElement leaveButton;

    @FindBy(id = "menu_time_viewTimeModule")
    public WebElement timeButton;

    @FindBy(id = "menu_recruitment_viewRecruitmentModule")
    public WebElement recruitmentButton;

    @FindBy(id = "menu__Performance")
    public WebElement performanceButton;

    @FindBy(id = "menu_dashboard_index")
    public WebElement dashboardButton;

    @FindBy(id = "menu_directory_viewDirectory")
    public WebElement directoryButton;

    public DashBoard(){
        PageFactory.initElements(driver,this);
    }
}
