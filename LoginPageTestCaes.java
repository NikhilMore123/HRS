package com.health.testcaes;

public class LoginPageTestCaes {

	WebDriver driver;
	@BeforeTest
	public void setup()
	{
	    System.setProperty("webdriver.firefox.marionette","pathToGeckodriver");
	    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	    FirefoxOptions options = new FirefoxOptions();
	    options.setHeadless(headless);
	    capabilities.merge(options);
	    driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://cc.healthrecoverysolutions.com/login");
	}
	@Test(priority=1)
	public void verify1()
	{
	  //to verify the sucessfull login and redirect to homepage
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertTrue(driver.getTitle().contains("ClinicianConnect"));
	}
	@Test(priority=2)
	public void verify2()
	{
	   //to verify the proper msg shown for invalid login name 
	   LoginPage login=new LoginPage(driver);
	    login.set_username("adm");
	    login.set_password("admin");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//div[2]/div[2]")).getText(),"Username and/or password invalid");
	}
	@Test(priority=3)
	public void verify3()
	{
	    //to verify the proper msg shown for invalid password
	    LoginPage login=new LoginPage(driver);
	    login.set_username("admin");
	    login.set_password("adm");
	    login.click_button();
	    Assert.assertEquals(driver.findElement(By.xpath("//*[@id='errorMessage']")).getText(),"Wrong username or password!");
	}
	@Test(priority=3)
	public void verify_forgetpassword()
	{
	    LoginPage login=new LoginPage(driver);
	    login.forget_password_click();
	    login.forget_password("admin");
	    Assert.assertEquals(driver.findElement(By.xpath("//div[2]/span")).getText(), "Reset password request successfully submitted.");

	}

	@AfterTest
	public void close()
	{
	    driver.close();
	}
	}
}
