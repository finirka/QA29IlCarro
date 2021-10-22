package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTest extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        //if(app.userHelper().isLogOutPresent()) {
           // app.search().clickButtonLogo();
        app.search().backToHomePage();

        //}
    }

    //10/20/2021-10/22/2021 - search by type
    //"09/20/2021-09/22/2021" - search for negative test

    @Test
    public void searchTestByType(){
        app.search().typeData("Haifa","10/25/2021","10/30/2021");
        app.userHelper().submitForm();
       // app.userHelper().pause(500);
        Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @Test
    public void SearchTestByTypeNegative(){
        app.search().typeData("Haifa","5/25/2021","6/30/2021");
        Assert.assertTrue(app.search().isButtonYallaActive());
       // Assert.assertFalse(app.userHelper().isYallaButtonActive());
    }

    @Test
    public void searchDataBySelectCurrentMonth(){
        app.search().fillSearchForm("Haifa","10/25/2021","10/30/2021");
        app.userHelper().submitForm();
        Assert.assertTrue(app.search().isListOfCarsAppeared());

    }

    @Test
    public void searchDataInFuture(){
        app.search().selectDataInFuture("Rehovot","11/15/2021","12/15/2021");
        app.userHelper().submitForm();
        //Assert.assertTrue(app.search().isListOfCarsAppeared());
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        //app.userHelper().clickOkButton();
        //app.search().clickButtonLogo();
    }
}
