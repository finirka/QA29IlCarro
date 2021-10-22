package application;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void  fillLoginForm(String email, String password){
        //type(By.id("em"), email);
        type(By.id("email"), email);
        //type(By.xpath("//*[@id='email']"),email);
        type(By.id("password"), password);
    }

    public void  fillLoginForm(User user){

        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm (String name, String lastName, String email, String password){
        type(By.id("name"), name);
        type(By.id("lastName"),lastName);
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    public void fillRegistrationForm (User user){
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void fillCheckBox(){
        click(By.cssSelector("label.checkbox-label.terms-label"));
        //click(By.xpath("//label[@for = 'terms-of-use']"));
    }

    public void submitForm () {
        click(By.xpath("//button[@type='submit']"));
    }


    //  //h2[text()='Logged in success']
    public boolean isLogged () {
        // //String text = wd.findElement(By.xpath("//h2[text()='Logged in success']")).getText();
        //String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        //click(By.xpath("//button[text()='Ok']"));
        //return text.equals("Logged in success");
        return wd.findElements(By.xpath("//a[.=' Log in ']")).size()>0;
    }

    //public boolean isRegistrated(){
    public boolean isLoggedSuccess(){
        String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        //click(By.xpath("//button[text()='Ok']"));
        // //click(By.cssSelector(".positive-button.ng-star-inserted"));
        //return text.equals("You are logged in success");
        return text.equals("Logged in success");
    }

    /*
    public boolean isNotRegistration(){
        //String text1 = wd.findElement(By.xpath("//div[text()=' Last name is required ']")).getText();
        //return text1.equals(" Last name is required ");
        return isElementPresent(By.xpath("//button[@disabled]"));
    }

*/

    public void logout () {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isLogOutPresent () {

        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public void clickOkButton() {
        if(isElementPresent(By.xpath("//button[.='Ok']"))) {
            click(By.xpath("//button[.='Ok']"));
        }
    }

    //JavascriptExecutor js = (JavascriptExecutor) wd;
    //    js.executeScript("document.querySelector('#terms-of-use').click();");
    //    js.executeScript("document.querySelector('#terms-of-use').checked=true;");

    public boolean isRegistrationSuccess() {
        //WebElement dialog = wd.findElement(By.cssSelector(".dialog-container h2"));
        //String message = dialog.getText();
        //return message.equals("You are logged in success");

        //WebElement dialog = wd.findElement(By.cssSelector(".dialog-container h1"));
        //String message = dialog.getText();
        //return message.equals("Registered");

        //String text = wd.findElement(By.cssSelector(".dialog-container h1")).getText();
        //return text.equals("Registered");
        //String text = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        //return text.equals("You are logged in success");
        return wd.findElements(By.xpath("//h2[@class='message']")).size()>0;


    }

    public boolean isErrorPasswordDisplayed() throws InterruptedException {
        // click(By.id("email"));
        Thread.sleep(2000);
        return isElementPresent(By.xpath("//div[@class='error ng-star-inserted']"));
        //return isElementPresent(By.xpath("//*[text()='Password must contain minimum 8 symbols']"));

    }

    public boolean isYallaButtonActive() {
        return wd.findElement(By.xpath("//button[@type='submit']")).isSelected();
        //return isElementPresent(By.xpath("//button[@disabled]"));
    }


    public boolean isLogInPresent() {
        return isElementPresent(By.xpath("//a[.=' Log in ']"));
    }
}
