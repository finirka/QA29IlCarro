package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.LocalDate;

public class SearchHelper extends HelperBase {


    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void fillSearchForm(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        selectData(dataFrom, dataTo);

    }

    //10/20/2021-10/22/2021
    private void selectData(String dataFrom, String dataTo) {
        String[] dataF = dataFrom.split("/");
        String[] dataT = dataTo.split("/");
        click(By.id("dates"));

        String locatorFrom = String.format("//div[text()=' %s ']", dataF[1]);
        //String locatorFrom1 = "//div[text()='%s']";
        String locatorTo = String.format("//div[text()=' %s ']", dataT[1]);

        click(By.xpath(locatorFrom));
        click(By.xpath(locatorTo));
    }

    public void selectDataInFuture(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        String[] dataT = dataTo.split("/");
        String[] dataF = dataFrom.split("/");

        click(By.id("dates"));

        int diffStart = 0;
        if (LocalDate.now().getMonthValue() != Integer.parseInt(dataF[0])) {
            diffStart = Integer.parseInt(dataF[0]) - LocalDate.now().getMonthValue();
        }

        int diff = 0;
        if (Integer.parseInt(dataF[0]) != Integer.parseInt(dataT[0])) {
            diff = Math.abs(Integer.parseInt(dataT[0]) - Integer.parseInt(dataF[0]));
        }

        for (int i = 0; i < diffStart; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locatorF = String.format("//div[text()=' %s ']", dataF[1]);
        click(By.xpath(locatorF));

        for (int i = 0; i < diff; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
        String locatorT = String.format("//div[text()=' %s ']", dataT[1]);
        click(By.xpath(locatorT));

    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
        pause(500);

        //Actions actions = new Actions(wd);
        //actions.moveToElement(wd.findElement(By.cssSelector(("pac-item")))).click().perform();

    }

    public boolean isListOfCarsAppeared() {
        return isElementPresent(By.cssSelector(".search-results"));
    }

    public void typeData(String city, String dataFrom, String dataTo) {
        fillInputCity(city);
        type(By.id("dates"), dataFrom + " - " + dataTo);
        click(By.cssSelector(".cdk-overlay-container"));
    }


    public boolean isButtonYallaActive() {
        WebElement el = wd.findElement(By.xpath("//button[@type='submit']"));
        return !el.isEnabled();
    }

    public void clickButtonLogo() {
        if (!isElementPresent(By.xpath("//h2[@class='subtitle']"))) {
            click(By.cssSelector("a[id='0']"));
        }
        // click(By.cssSelector("div[class='header'] img[alt='logo']"));
        pause(500);
        //wd.findElement(By.id("dates")).clear();
        //wd.findElement(By.id("city")).clear();
    }
}
