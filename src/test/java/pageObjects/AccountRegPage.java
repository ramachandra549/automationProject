package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends BasePage {

	public AccountRegPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(name="firstname") WebElement fname_txt;
	@FindBy(name="lastname") WebElement lname_txt;
	@FindBy(id="input-email") WebElement email_txt;
	@FindBy(id="input-telephone") WebElement ph_txt;
	@FindBy(id="input-password") WebElement pwd_txt;
	@FindBy(id="input-confirm") WebElement confirmPwd_txt;
	@FindBy(name="agree") WebElement chk_btn;
	@FindBy(xpath="//input[@type='submit']") WebElement continue_btn;
	
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement successfull_txt;
	
	public void clickFname(String name)
	{
		fname_txt.sendKeys(name);
	}
	
	public void clickLname(String name)
	{
		lname_txt.sendKeys(name);
	}
	public void clickEmail(String email)
	{
		email_txt.sendKeys(email);
	}
	public void clickPhone(String ph)
	{
		ph_txt.sendKeys(ph);
	}
	public void clickPwd(String pwd)
	{
		pwd_txt.sendKeys(pwd);
	}
	public void clickConfirmPwd(String pwd)
	{
		confirmPwd_txt.sendKeys(pwd);
	}
	public void clickChkBtn()
	{
		chk_btn.click();
	}
	public void clickContinueBtn()
	{
		continue_btn.click();
	}
	
	
	public String getMessage()
	{
		try {
			return(successfull_txt.getText());
		}
		catch(Exception e) 
		{
			return(e.getMessage());
		}
	}
	
}
