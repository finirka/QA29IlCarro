package application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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



    public void pause(int millies){
        try {
            Thread.sleep(millies);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

