package application;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import  com.google.common.io.Files;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        //if (isElementPresent(By.xpath("//button[.='Ok']"))) {
        //    click(By.xpath("//button[.='Ok']"));
            wd.findElement(locator).click();
        //}
    }

    public void type(By locator, String text) {
        //if (text != null) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
       // }
    }

    public boolean isElementPresent (By locator){
        return wd.findElements(locator).size() > 0;
    }

    public void backToHomePage() {
        wd.findElement(By.xpath("//a[@href='/']")).click();

    }

    public void pause(int millies){
        try {
            Thread.sleep(millies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void takeScreenShot(String pathToFile) {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

        File screenshot = new File(pathToFile);
        try {
            Files.copy(tmp,screenshot);
        }catch (IOException e){
            e.printStackTrace();
        }



    }

}

