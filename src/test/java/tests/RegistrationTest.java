package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.userHelper().isLogOutPresent()) {
            app.userHelper().logout();
        }
    }
    /*
    @Test(groups = {"web"})
    public void registrationSuccess() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        app.userHelper().openRegistrationForm();
        //app.userHelper().fillRegistrationForm("Noa","Last","noa"+i+"@gmail.com","Nnoa12345$");
        app.userHelper().fillRegistrationForm("Lis", "Slow", "slow" + i + "@gmail.com", "Ss1234" + i + "$");
        app.userHelper().fillCheckBox();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());
    }
*/
    @Test
    public void registrationSuccessModel() {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
        User user = new User()
                .withName("Lis").withLastName("Slow").withEmail("slow" + i + "@gmail.com").withPassword("Ss1234" + i + "$");

        logger.info("TestData: name: " + user.getName() + ", Last name: " + user.getLastName() + ", E-mail: " + user.getEmail() + ", Password: " + user.getPassword());
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm(user);
        logger.info("openRegistrationForm appeared");
        app.userHelper().fillCheckBox();
        logger.info("openRegiatration Form filled");
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());
    }

/*
    @Test
    public void registrationTest2(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Lis","Slow","slow"+i+"@gmail.com","Ss12"+i+"$");
        app.userHelper().fillCheckBox();
        app.userHelper().submitForm();
        Assert.assertTrue(app.userHelper().isRegistrationSuccess());

    }

    @Test
    public void negativeRegistrationExistAccount(){
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Noa","Last","noa1@gmail.com","Nnoa12345$");
        app.userHelper().fillCheckBox();
        app.userHelper().submitForm();
        Assert.assertFalse(app.userHelper().isRegistrated());
    }

    @Test
    public void negativeRegistrationWithoutName(){
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("","Last","noa@gmail.com","Nnoa12345$");
        app.userHelper().fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(app.userHelper().isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutLastName(){
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Noa","","noa@gmail.com","Nnoa12345$");
        app.userHelper().fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(app.userHelper().isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutEmail(){
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Noa","Last","","Nnoa12345$");
        app.userHelper().fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(app.userHelper().isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutPassword(){
        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Noa","Last","noa@gmail.com","");
        app.userHelper().fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(app.userHelper().isNotRegistration());
    }
*/

    @Test
    public void registrationTestNegative() throws InterruptedException {

        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        app.userHelper().openRegistrationForm();
        app.userHelper().fillRegistrationForm("Lis", "Slow", "slow" + i + "@gmail.com", "12" + i);
        app.userHelper().fillCheckBox();
        app.userHelper().submitForm();
        Thread.sleep(3000);
        //Assert.assertTrue(app.userHelper().isErrorPasswordDisplayed());
        //Assert.assertTrue(app.userHelper().isYallaButtonActive());
        Assert.assertFalse(app.userHelper().isYallaButtonActive());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        app.userHelper().clickOkButton();
    }
}
