package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {

    WebDriver driver;
    private Login loginPage;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }
    public Login getLoginPage() {
        if (loginPage == null) {
            loginPage = new Login(driver);
        }
        return loginPage;
    }
}
