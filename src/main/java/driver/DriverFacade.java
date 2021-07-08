package driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverFacade {
    public AndroidDriver<AndroidElement> driver = null;

    public DriverFacade() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            //Real device
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "N0AA003761K70700091");
            caps.setCapability("appPackage", "wta.com.picatrebax");
            caps.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");
            //caps.setCapability("noReset", "true");
            caps.setCapability(MobileCapabilityType.APP, "/home/dmitry/Desktop/app-debug.apk");
            caps.setCapability("autoAcceptAlerts", true);
            caps.setCapability("autoGrantPermissions", true);

            //Initiate Driver for Real Devices
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

            //Browserstack
            /*caps.setCapability("browserstack.user", "dimazasuha1");
            caps.setCapability("browserstack.key", "FjKjiV8QKrmHpjuxQVpG");
            caps.setCapability("fullReset", "true");
            caps.setCapability("autoAcceptAlerts", "true");
            caps.setCapability("autoGrantPermissions", "true");
            caps.setCapability("browserstack.debug", "true");

            caps.setCapability("app", "bs://49b6edea69a1d25374ed3a9b1dd6da3bce8388c5");
            caps.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");

            caps.setCapability("device", "Samsung Galaxy S10e");
            caps.setCapability("os_version", "9.0");

            caps.setCapability("project", "What The Art");
            caps.setCapability("build", "1.0.6");
            caps.setCapability("name", "Positive scenario test");

            HashMap<String, String> passportsAndNames = new HashMap<>();
            passportsAndNames.put("username", "dmitry.zasuha@gmail.com");
            passportsAndNames.put("password", "QWE123qwe@");
            caps.setCapability("browserstack.appStoreConfiguration", passportsAndNames);

            //Initiate Driver for Browserstack
            driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);*/

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void StopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public void chooseAnswer (String answerId) {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().clickable(true).resourceId(" + answerId + "))"));
        element.click();
    }

    public void tapNextTheoryButton() {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"NEXT\"))"));
        element.click();
    }

    public void tapCheckButton() {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().textContains(\"CHECK\"));"));
        element.click();
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebElement waitForElement(By locator) {
        try {
            return new WebDriverWait(driver, 25)
                    .until(ExpectedConditions.visibilityOf((WebElement) locator));
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            throw new RuntimeException(e);
        }
    }

    public void chooseCourse (By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(4).click();
        } catch (Exception e) {
            System.out.println("Locator of the course can not be found");
            System.out.println(e.getMessage());
        }
    }

    public void chooseElement (By locator, int themeId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).get(themeId).click();
            System.out.println(locator);
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            System.out.println(e.getMessage());
        }
    }

    public void chooseImageAnswer (By locator, int themeId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(themeId).click();
            System.out.println(locator);
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            System.out.println(e.getMessage());
        }
    }

    public void getContext() {
        wait(5);
        Set<String> contextNames = driver.getContextHandles();
        System.out.println(contextNames);
    }

    public void tapElement (By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 25);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
    }


    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() != 0;
    }

    public WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

/*    public void alert () {
        Alert alert = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }*/
}
