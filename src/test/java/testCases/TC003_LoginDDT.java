package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven") //getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String exp)
	{
	
		logger.info("********Starting TC003_LoginTest*******");
		try {
	//HomePage
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
	//Login Page
	
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
			
	//My Account
		
		MyAccountPage macp=new MyAccountPage(driver);			
		boolean targetpage =macp.isMyAccountPageExists();
		
		/* Data is valid - login success - test pass - logout
		                   login failed - test fail
		 * Data is invalid - login success - test fail - logout
		                     login failed - test pass
		 */
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (targetpage==true)
			{
				macp.clicklogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if (targetpage==true)
			{
				macp.clicklogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		} catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("********Finished TC003_LoginTest*******");
}
}
