package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass {
	
	@Test(groups="Regression")
	public void login()
	{
		logger.info("*****Starting for Login ***********");
		try
		{
			Homepage hp=new Homepage(driver);
			hp.clickMyAccount_btn();
			logger.info("*****Clicked my account link ***********");
			hp.clickLogin_btn();
			logger.info("*****Clicked login option ***********");
			
			LoginPage lp=new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setpwd(p.getProperty("pwd"));
			lp.clickLoginbtn();
			logger.info("*****Logged into the Application ***********");
			MyAccountPage myAcc=new MyAccountPage(driver);
			boolean targetPage=myAcc.isMyAccountPage();
			
			Assert.assertEquals(targetPage,true,"Loginfailed");
			
//			Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}

	
}
