package com.TestPageCase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPage.LoginPage;

public class LoginPageTest extends TestBase {
LoginPage loginpage;
	public LoginPageTest() {
		
		super();
	}
	
	
	@BeforeMethod	
	public void SetUp() throws Exception {		
		initil();
		loginpage = new LoginPage();
		Thread.sleep(5000);
	}
	
	@Test(priority =0)
	public void VerifyLoginPage() throws Exception {
		loginpage.VerifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));		
	Thread.sleep(5000);
	}
	
	@Test(priority =1)
	public void VerifyTitleofThePage() throws Exception {
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
		Thread.sleep(2000);
	}
	
	@Test(priority =2)
	public void verifyLogoofThePage() throws Exception {
		boolean logo = loginpage.verifyLogo();
		Assert.assertTrue(logo);	
		Thread.sleep(2000);
}
@AfterMethod
public void TearDown() {
	driver.quit();
}
}
	
	
	
	
