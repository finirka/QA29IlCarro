package application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyListener extends AbstractWebDriverEventListener {
    Logger logger = LoggerFactory.getLogger(MyListener.class);

    public MyListener(){
        super();
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("The element  ---> "+by+" was found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        logger.info("We have a throwable --> "+throwable.getMessage());
        logger.info("We have a throwable --> "+throwable.fillInStackTrace());


        int i = (int) (System.currentTimeMillis()/1000)%3600;
        String screenshot = "src/test/screenshots/screen-"+i+".png";
        HelperBase helperBase = new HelperBase((driver));
        helperBase.takeScreenShot(screenshot);
        logger.info("Screen with throwable --->"+screenshot);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
       logger.info("Start find element by------>  ",by);
    }


}
