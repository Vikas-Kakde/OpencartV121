package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("********Starting TC002_LoginTest*******");
		try {
		//HomePage
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//My Account
		
		MyAccountPage macp=new MyAccountPage(driver);
		
		boolean targetpage =macp.isMyAccountPageExists();
		Assert.assertTrue(targetpage);//Assert.assertEquals(targetpage, true, "Login Failed");
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		
		logger.info("********Finished TC002_LoginTest*******");
	}

}
