package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RentTest extends TestBase{
 /*   @BeforeMethod
    public void preCondition(){
        //login?
    }
 */
    @Test
    public void rentWithLogin() {
       //if login?
       app.search().typeData("Haifa", "11/22/2021", "11/30/2021");
       app.userHelper().submitForm();
       //Assert.assertTrue(app.search().isListOfCarsAppeared());
       if (app.search().isListOfCarsAppeared() == true) {
          app.rent().choiceCar();
       }
       if (app.userHelper().isLogOutPresent()) {
          app.rent().addPhone("0532223344");
          app.userHelper().submitForm();
          Assert.assertTrue(app.rent().isOrderSuccess());
          // app.rent().closeForm()
       }
    }

    @Test
    public void rentWithoutLogin(){
        //if login?
       app.search().typeData("Haifa","12/04/2021","12/05/2021");
       app.userHelper().submitForm();
       //Assert.assertTrue(app.search().isListOfCarsAppeared());
       if(app.search().isListOfCarsAppeared() == true){
          app.rent().choiceCar();
       }
       if(app.userHelper().isLogInPresent()){
          app.rent().fillLoginFormForRent("nnoa@gmail.com","Nn12345$");
       }
       app.rent().addPhone("0532223344");
       app.userHelper().submitForm();
       Assert.assertTrue(app.rent().isOrderSuccess());
       app.rent().closeForm();

    }
}
