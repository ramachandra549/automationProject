package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email,String pwd,String exp)
	{
		logger.info("*****TC003_LoginDDT testcase ***********");
		try
		{
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount_btn();
		logger.info("*****Clicked my account link ***********");
		hp.clickLogin_btn();
		logger.info("*****Clicked login option ***********");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setpwd(pwd);
		lp.clickLoginbtn();
		logger.info("*****Logged into the Application ***********");
		MyAccountPage myAcc=new MyAccountPage(driver);
		boolean targetPage=myAcc.isMyAccountPage();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				myAcc.clickOnLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				myAcc.clickOnLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC003 Login Test case_DDT***********");
		
		
	}
	
	
}
