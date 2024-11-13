package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{
	
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);//passing driver to the parent class constructor
	}
	
//locators or elements  	
@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txtLasttname;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtEmail;

@FindBy(xpath="//input[@id='input-telephone']") 
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']") 
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']") 
WebElement chkdPolicy;

@FindBy(xpath="//button[normalize-space()='Continue']") 
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

//action methods
//for every element we need to create an action method
public void setFirstName(String fname) {
	txtFirstname.sendKeys(fname);

}

public void setLastName(String lname) {
	txtLasttname.sendKeys(lname);

}

public void setEmail(String email) {
	txtEmail.sendKeys(email);

}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);

}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}

public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);

}

public void setPrivacyPolicy() {
	chkdPolicy.click();

}

public void clickContinue() {
	//sol1 
	btnContinue.click();
	
	//sol2 
	//btnContinue.submit();
	
	//sol3
	//Actions act=new Actions(driver);
	//act.moveToElement(btnContinue).click().perform();
				
	//sol4
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("arguments[0].click();", btnContinue);
	
	//Sol 5
    //btnContinue.sendKeys(Keys.RETURN);
	
	//Sol6  
    //WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
	
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());//just returning the text
	} catch (Exception e) {
		return (e.getMessage());//sometimes msg will not displayed bcoz of failing of registration then it will give exception msg
//here we are not doing any validation. based on this return value we will do validation inside test case class
	}

}


}
