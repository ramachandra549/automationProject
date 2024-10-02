package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement myAccountHeading_msg;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement logoutlink;
	
	
	public boolean isMyAccountPage()
	{
		try
		{
			System.out.println(myAccountHeading_msg.getText());
			return (myAccountHeading_msg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickOnLogout()
	{
		logoutlink.click();
	}

	

}
