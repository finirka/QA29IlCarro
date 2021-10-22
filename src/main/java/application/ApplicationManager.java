package application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver wd;
    EventFiringWebDriver wd;
    UserHelper userHelper;
    HelperCar car;
    SearchHelper search;
    RentHelper rent;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
        }else if (browser.equals(BrowserType.FIREFOX)){
            wd= new EventFiringWebDriver(new FirefoxDriver());
        }

        wd.register(new MyListener());

        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        car = new HelperCar(wd);
        search = new SearchHelper(wd);
        rent = new RentHelper(wd);


    }

    public void stop() {
        //wd.quit();
    }

    public RentHelper rent() {
        return rent;
    }

    public UserHelper userHelper() {
        return userHelper;
    }

    public HelperCar car() {
        return car;
    }

    public SearchHelper search() {
        return search;
    }
}

