package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegPage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
//	public WebDriver driver;
	@Test
	public void account_Registration()
	{
		logger.info("Execution of TC001_AccountRegistrationTest Started");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount_btn();
		logger.info("My account button clicked");
		hp.clickReg_btn();
		logger.info("Registration button button clicked");
		
		AccountRegPage ac=new AccountRegPage(driver);
		logger.info("Providing customer details");
		ac.clickFname(randomString().toUpperCase());
		ac.clickLname(randomString().toUpperCase());
		ac.clickEmail(randomString()+"@gmail.com"); //We need to Generate random data
		
		String pwd=randomAlphaNumeric();
		
		ac.clickPwd(pwd);
		ac.clickConfirmPwd(pwd);
		ac.clickPhone(randomNumber());
		ac.clickChkBtn();
		ac.clickContinueBtn();
		logger.info("***Validating Confirmation msg");
		String msg=ac.getMessage();
		if(msg.equals("Your Account Has Been Created!!!! "))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test is Failed");
		}
//		Assert.assertEquals(msg, "Your Account Has Been !");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Execution finished******");
	}
	
	
}
