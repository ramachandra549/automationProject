package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
		
	//webElements in login page
	@FindBy(xpath="//input[@id='input-email']") WebElement emailField;
	@FindBy(xpath="//input[@id='input-password']") WebElement pwdField;
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") WebElement forgotpwdField;
	@FindBy(xpath="//input[@value='Login']") WebElement loginbtn;
	
	//action methods
	public void setEmail(String email)
	{
		emailField.sendKeys(email);
	}
	public void setpwd(String pwd)
	{
		pwdField.sendKeys(pwd);
	}
	public void clickForgotPwd()
	{
		forgotpwdField.click();
	}
	public void clickLoginbtn()
	{
		loginbtn.click();
	}
	
	
	
	
	
	
	

}
