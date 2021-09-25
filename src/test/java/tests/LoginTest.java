package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.userHelper().isLogOutPresent()){
            app.userHelper().logout();
        }
    }

    @Test
    public void loginSuccess(){

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("nnoa@gmail.com","Nn12345$");
        app.userHelper().submitForm();
        //app.userHelper().clickOkButton();
        Assert.assertTrue(app.userHelper().isLogged());
        //Assert.assertTrue(app.userHelper().isLoggedSuccess());
    }

    @Test
    public void loginSuccessModel(){
        User user = new User()
                .withEmail("slow@gmail.com").withPassword("Ss12345$");

        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitForm();
        //app.userHelper().clickOkButton();
        //Assert.assertTrue(app.userHelper().isLogged());
        Assert.assertTrue(app.userHelper().isLoggedSuccess());
    }

    @Test
    public void negativeLoginWrongPassword(){
        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm("noa@gmail.com","Nnoa123456");
        app.userHelper().submitForm();
        //app.userHelper().clickOkButton();
        //Assert.assertFalse(app.userHelper().isLogged());
        Assert.assertFalse(app.userHelper().isLoggedSuccess());

    }

    @AfterMethod
    /*
    public void postCondition(){
        if(app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
*/

    public void postCondition(){

        app.userHelper().clickOkButton();
    }
}
