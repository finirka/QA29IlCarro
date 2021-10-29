package tests;

import models.Car;
import models.CarNew;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{

    @BeforeMethod
    public void preCondition(){
     //login
        //if(app.userHelper().isLogOutPresent()){}
        //else {
        if(!app.userHelper().isLogOutPresent()){
            app.userHelper().openLoginForm();
            app.userHelper().fillLoginForm("nnoa@gmail.com", "Nn12345$");

            app.userHelper().submitForm();
        }

    }
/*
    @Test
    public void addNewCar(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Car car = new Car()
                .withAddress("Tel Aviv, Israel")
                .withMake("BMW")
                .withModel("M5")
                .withYear("2020")
                .withEngine("2.3")
                .withFuel("Petrol")
                .withGear("MT")
                .withWD("AWD")
                .withDoors("5")
                .withSeats("4")
                .withClasS("C")
                .withFuelConsumption("6.5")
                .withCarRegNumber("100-66-"+i)
                .withPrice("65")
                .withDistanceIncluded("500")
                .withTypeFeature("type of")
                .withAbout(" Very good car");

        app.car().initAddingnewCar();
        app.car().fillCarForm(car);
        app.car().attachPhoto();
        app.car().clickButtonSubmit();
        Assert.assertTrue(app.car().isCarAdded());
    }
*/
    @Test
    public void addNewCarSuccessModelCarNew(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        CarNew car = CarNew.builder()
                .address("Tel Aviv, Israel")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("4")
                .clasS("C")
                .fuelConsumption("6.5")
                .carRegNumber("100-66-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about(" Very good car")
                .build();

        app.car().initAddingnewCar();
        app.car().fillCarForm(car);
        app.car().attachPhoto();
        app.car().clickButtonSubmit();
        Assert.assertTrue(app.car().isCarAdded());

    }

    @AfterMethod
    public void postCondition(){
        app.car().clickCarButton();

    }
}
