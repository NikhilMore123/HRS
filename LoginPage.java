package com.health.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	public class LoginPage 
	{
	    private WebDriver driver;

	       @FindBy(id="loginEmail")
	       WebElement username;
	       @FindBy(id="password")
	       WebElement password;
	       @FindBy(id="loginSubmitButton")
	       WebElement button;
	       @FindBy(id="resetPassword_username")
	       WebElement forgetButton;
	   
	       public LoginPage(WebDriver driver)
	       {
	        //initialize elements
	          PageFactory.initElements(driver, this);

	       }
	       public void set_username(String usern)
	       {
	        username.clear();
	        username.sendKeys(usern);
	       }
	       public void set_password(String userp)
	       {
	        password.clear();
	        password.sendKeys(userp);
	       }
	        public void forget_password_click()
	       {
	        forget_password.click();
	        
	       }
	       public void forget_password(String forgetp)
	       {
	        
	        forget_password.sendKeys(forgetp);
	       }

	       public void click_button()
	       {
	        button.submit();
	       }
	}



