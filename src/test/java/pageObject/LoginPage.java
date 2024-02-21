package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;
	
	@FindBy(xpath= "//*[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//*[@id='pass']")
	WebElement Password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement LoginButton;
	
	@FindBy(xpath="//*[@id='mhdrAppBtn']")
	WebElement HomePageButton;
	
	@FindBy(xpath="//*[@id='mhdrSite']")
	WebElement LNButton;
	
	@FindBy(xpath="//*[@id='node-mtppdm00000000']") WebElement Project;
	public void ClickonProject() {
		Project.click();
	}
	
	@FindBy(xpath="(//*[@class='m-app-frame'])[1]") WebElement Iframe;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void EnterUsername(String Name) {
		username.sendKeys(Name);
	}
	public void EnterPassword(String password) {
		Password.sendKeys(password);
	}
	public WebElement getLogin() {
		return LoginButton;
	}
	public void ClickOnHomePage() {
		HomePageButton.click();
	}
	public void ClickOnLNbutton() {
		LNButton.click();
	}
	
}


