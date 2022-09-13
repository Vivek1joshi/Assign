package Pages;

import Configuration.ExtentLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    WebDriver driver;

    @FindBy(xpath = "//div[@class='form-group']//following::input[@class='form-control ng-pristine ng-invalid ng-touched']")
    private WebElement Username;
    @FindBy(xpath = "//input[@class='form-control ng-untouched ng-pristine ng-invalid']")
    private WebElement Email;
    @FindBy(linkText = "//div[@class='form-group']//following::input[@type='password']")
    private WebElement Password;
    @FindBy(xpath = "//div[@class='form-group']//following::input[@type='checkbox']")
    private WebElement Select_Checkbox;
    @FindBy(xpath = "//input[@id='btnLogin']")
    private WebElement Click_On_LoginButton;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void SignUp(String url) {
        Actions action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
        driver.get(url);
        ExtentLogger.pass("Enter username:- "+url);
        action.moveToElement(Username).sendKeys("Admin");
        ExtentLogger.pass("Enter username:- "+Username);
        action.moveToElement(Email).sendKeys("vivekjoshi@yopmail.com");
        ExtentLogger.pass("Enter username:- "+Email);
        action.moveToElement(Password).sendKeys("Vivek@123");
        ExtentLogger.pass("Enter username:- "+Password);
        action.moveToElement(Select_Checkbox).click();

    }
    public void VerifyHomePage(){
        String actual = driver.getCurrentUrl();
        String expected = "https://rahulshettyacademy.com/angularpractice/";
        Assert.assertEquals(actual,expected,"Home page is not verified");
    }
}
