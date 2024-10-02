package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BasePage {

	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//a[@title='My Account']") WebElement myAcc_btn;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement reg_btn;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login_btn;
	
	//Action Methods
	public void clickMyAccount_btn()
	{
		myAcc_btn.click();
	}
	public void clickReg_btn()
	{
		reg_btn.click();
	}
	public void clickLogin_btn()
	{
		login_btn.click();
	}
	
	
	
}
