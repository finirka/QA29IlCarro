package tests;

import application.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.userHelper().isLogOutPresent()){
            app.userHelper().logout();
        }
    }

    @DataProvider
    public Iterator<Object[]> validDataLogin(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"nnoa@gmail.com","Nn12345$"});
        list.add(new Object[]{"noa@gmail.com","Nn12345$"});
        list.add(new Object[]{"sonya@gmail.com","Ss12345$"});
        return list.iterator();
    }

    //@Test(dataProvider = "validDataLogin")
    @Test(dataProvider = "validDataLogin",dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email,String password){
       // logger.info("Login with email: nnoa@gmail.com & password: Nn12345$ ");

        app.userHelper().openLoginForm();
       // app.userHelper().fillLoginForm("nnoa@gmail.com","Nn12345$");
        app.userHelper().fillLoginForm(email,password);
        app.userHelper().submitForm();
        //app.userHelper().clickOkButton();
        //app.userHelper().takeScreenShot(src/test/screenshots/111.png);
        Assert.assertTrue(app.userHelper().isLogged());
        //Assert.assertTrue(app.userHelper().isLoggedSuccess());

    }

    @DataProvider
    public Iterator<Object[]> dataLoginCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader =
                new BufferedReader(new FileReader("src/test/resources/data.csv"));
        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().withEmail(split[0]).withPassword(split[1])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test
    public void test(){

    }

    //@Test(dataProvider = "dataLoginCSV")
    @Test(dataProvider = "dataLoginCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessModel(User user){
        //User user = new User()
        //        .withEmail("slow@gmail.com").withPassword("Ss12345$");


        app.userHelper().openLoginForm();
        app.userHelper().fillLoginForm(user);
        app.userHelper().submitForm();
        //app.userHelper().clickOkButton();
        Assert.assertTrue(app.userHelper().isLogged());
        //Assert.assertTrue(app.userHelper().isLoggedSuccess());
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

    @AfterMethod(alwaysRun = true)
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
