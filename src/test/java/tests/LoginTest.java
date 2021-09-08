package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
    public void loginSuccess(){
        openLoginForm();
        fillLoginForm("noa@gmail.com","Nnoa12345$");
        submitForm();
        Assert.assertTrue(isLogged());
    }

    @Test
    public void negativeLoginWrongPassword(){
        openLoginForm();
        fillLoginForm("noa@gmail.com","Nnoa123456");
        submitForm();
        Assert.assertFalse(isLogged());
    }

    @AfterMethod
    public void postCondition(){
        if(isLogOutPresent()) {
            logout();
        }

    }

}
