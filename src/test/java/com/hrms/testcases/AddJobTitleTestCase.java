package com.hrms.testcases;

import com.hrms.pages.*;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddJobTitleTestCase extends CommonMethods {

    @Test
    public void addJobTitle() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login(ConfigReader.getPropertyValue("username"),ConfigReader.getPropertyValue("password"));

        DashBoard dashBoard=new DashBoard();
        clickWaitForClickability(dashBoard.adminButton);

        AdminPage adminPage=new AdminPage();
        Actions action=new Actions(driver);
        Thread.sleep(2000);
        action.moveToElement(adminPage.jobButton).perform();
        Thread.sleep(2000);
        clickWaitForClickability(adminPage.jobTitlesButton);

        List<Map<String,String>> jobs= ExcelUtility.excelDataToList(Constants.TESTDATA_FILEPATH,"employee");


        Iterator<Map<String,String>> iterator=jobs.iterator();

        while(iterator.hasNext()){
            JobTitleList jobTitleList=new JobTitleList();
            clickWaitForClickability(jobTitleList.addBtnJobTitle);

            AddJobTitle addJobTitle=new AddJobTitle();
            Map<String,String> job=iterator.next();


            sendText(addJobTitle.jobTitleField,job.get("JobTitle"));
            sendText(addJobTitle.jobDescriptionField,job.get("JobDescription"));
            sendText(addJobTitle.jobSpecificationField,job.get("JobSpecification"));
            sendText(addJobTitle.noteField,job.get("Note"));
            clickWaitForClickability(addJobTitle.saveButton);

        }
    }

}
