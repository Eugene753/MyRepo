package com.hrms.testcases;

import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginPageTest extends CommonMethods {


    @Test
    public void logo(){
        LoginPage loginPage=new LoginPage();
        Assert.assertTrue(displayed(loginPage.syntaxLogo));
    }

@DataProvider
    public Object[][] userNamesLogin(){
    Object[][] data={{"Admin","","Password cannot be empty"},
            {"",ConfigReader.getPropertyValue("password"),"Username cannot be empty"},
            {"Admi","Hum@nhrm","Csrf token validation failed"},
            {ConfigReader.getPropertyValue("username"),"Hum@nhrm1","Invalid credentials"},
            {"Adm",ConfigReader.getPropertyValue("password"),"Invalid credentials"}};
    return data;
}

@Test(dataProvider = "userNamesLogin")
    public void messageDisplay(String username,String password,String expectedMessage){
        LoginPage loginPage=new LoginPage();
        sendText(loginPage.userNameBox,username);
        sendText(loginPage.passwordBox,password);
        loginPage.loginBtn.click();

        String actualMessage=loginPage.spanMessage.getText();

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(actualMessage,expectedMessage,"Incorrect message is displayed");
}


}
