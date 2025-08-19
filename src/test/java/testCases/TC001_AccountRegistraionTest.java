package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistraionTest extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("**********Starting TC001_AccountRegistraionTest *******");
		try
		{
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password =randomeAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setCnfPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expecetd message");
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	
	catch (Exception e)
	{
		logger.error("Test Failed...");
		logger.error("Debug logs...");
		Assert.fail();
	}
		logger.info("**********finished TC001_AccountRegistraionTest *******");
	
	}
}
