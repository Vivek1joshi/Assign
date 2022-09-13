package Test;

import org.testng.annotations.Test;

public class Verifythatusersuccessffullylogin extends BaseTest {
    @Test(dataProvider="WebsiteLoginData")
    public void Test1(String url)
    {
        pageFactory.getLoginPage().SignUp(url);
        pageFactory.getLoginPage().VerifyHomePage();
    }

}
