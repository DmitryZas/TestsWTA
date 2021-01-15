package driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverFacade {
    public AndroidDriver<AndroidElement> driver = null;

    public DriverFacade() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            //Local device
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "8524e42f7d94");
            //caps.setCapability("appPackage", "wta.com.picatrebax");
            caps.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");
            caps.setCapability("noReset", "true");
            caps.setCapability(MobileCapabilityType.APP, "/home/dmytro/Desktop/app-UIdebug.apk");
            //caps.setCapability("autoAcceptAlerts", true);
            caps.setCapability("autoGrantPermissions", "true");

            /*//Browserstack
            // Set your access credentials
            caps.setCapability("browserstack.user", "dimazasuha1");
            caps.setCapability("browserstack.key", "FjKjiV8QKrmHpjuxQVpG");

            // Set URL of the application under test
            caps.setCapability("app", "bs://b02755ccf4384499c8dd6a7471b24580d025af6f");
            caps.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");
            caps.setCapability("noReset", "true");

            // Specify device and os_version for testing
            caps.setCapability("device", "Samsung Galaxy S10e");
            caps.setCapability("os_version", "9.0");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "What The Art");
            caps.setCapability("build", "0.97");
            caps.setCapability("name", "Positive scenario test");

            // Set credentials for Google Authorization
            HashMap<String, String> passportsAndNames = new HashMap<>();
            passportsAndNames.put("username", "testforwta@gmail.com");
            passportsAndNames.put("password", "QWE123qwe!");
            caps.setCapability("browserstack.appStoreConfiguration", passportsAndNames);*/

            //Initiate Driver
            //driver = new AndroidDriver<>(new URL("http://hub.browserstack.com/wd/hub"), caps);
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
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

    public void tapNextTheoryButton() {
        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*wta.com.picatrebax:id/next.*\"))"));
        element.click();
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebElement waitForElement(AndroidElement locator) {
        try {
            return new WebDriverWait(driver, 25)
                    .until(ExpectedConditions.visibilityOf(locator));
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            throw new RuntimeException(e);
        }
    }

    public void chooseCourse (By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(4).click();
            /*wait(5);
            List<AndroidElement> course = driver.findElementsByClassName(locator);
            course.get(4).click();*/
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            System.out.println(e.getMessage());
        }


    }

    public void chooseTheme (By locator, int themeId) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)).get(themeId).click();
        } catch (Exception e) {
            System.out.println("Locator can not be found");
            System.out.println(e.getMessage());
        }
      /*  List<AndroidElement> course = driver.findElementsById(locator);
        course.get(themeId).click();*/
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
 }
