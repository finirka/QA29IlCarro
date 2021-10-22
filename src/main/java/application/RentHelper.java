package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RentHelper extends HelperBase {
    public RentHelper(WebDriver wd) {
        super(wd);
    }


    public void choiceCar() {
    click(By.xpath("//span[text()='Volvo S60']"));
        pause(500);
        click(By.xpath("//button[.='Rent now!! ']"));

    }

    public void fillLoginFormForRent(String email, String password) {
        type(By.xpath("//input[@id='email']"),email);
        type(By.xpath("//input[@id='password']"),password);
        click(By.xpath("//button[@type='submit']"));
        pause(500);
        click(By.xpath("//button[.='Rent now!! ']"));
        pause(500);

    }

    public void addPhone(String phone) {
        type(By.xpath("//input[@id='phone']"), phone);
    }

    public boolean isOrderSuccess() {
        String text = wd.findElement(By.xpath("//div[@class='dialog-container']//h1[@class='title']")).getText();
        //click(By.xpath("//button[text()='Ok']"));
        // //click(By.cssSelector(".positive-button.ng-star-inserted"));
        //return text.equals("You are logged in success");
        return text.equals("Order success");
    }

    public void closeForm() {
        click(By.xpath("//button[@class='positive-button ng-star-inserted']"));

    }
}