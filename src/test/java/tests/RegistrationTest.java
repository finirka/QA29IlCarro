package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void registrationSuccess(){
        openRegistrationForm();
        fillRegistrationForm("Noa","Last","noa1@gmail.com","Nnoa12345$");
        fillCheckBox();
        submitForm();
        Assert.assertTrue(isRegistrated());
    }

    @Test
    public void negativeRegistrationExistAccount(){
        openRegistrationForm();
        fillRegistrationForm("Noa","Last","noa1@gmail.com","Nnoa12345$");
        fillCheckBox();
        submitForm();
        Assert.assertFalse(isRegistrated());
    }

    @Test
    public void negativeRegistrationWithoutName(){
        openRegistrationForm();
        fillRegistrationForm("","Last","noa@gmail.com","Nnoa12345$");
        fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutLastName(){
        openRegistrationForm();
        fillRegistrationForm("Noa","","noa@gmail.com","Nnoa12345$");
        fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutEmail(){
        openRegistrationForm();
        fillRegistrationForm("Noa","Last","","Nnoa12345$");
        fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(isNotRegistration());
    }

    @Test
    public void negativeRegistrationWithoutPassword(){
        openRegistrationForm();
        fillRegistrationForm("Noa","Last","noa@gmail.com","");
        fillCheckBox();
        //noSubmitForm();
        Assert.assertTrue(isNotRegistration());
    }

}
