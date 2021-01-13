package driver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverFacade {
    //private static AndroidDriver CalculatorSession = null;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {


        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials
        caps.setCapability("browserstack.user", "dimazasuha1");
        caps.setCapability("browserstack.key", "FjKjiV8QKrmHpjuxQVpG");

        // Set URL of the application under test
        caps.setCapability("app", "bs://b02755ccf4384499c8dd6a7471b24580d025af6f");
        caps.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");
        caps.setCapability("noReset", "true");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");

        HashMap<String, String> passportsAndNames = new HashMap<>();
        passportsAndNames.put("username", "testforwta@gmail.com");
        passportsAndNames.put("password", "QWE123qwe!");

        System.out.println(passportsAndNames);

        caps.setCapability("browserstack.appStoreConfiguration", passportsAndNames);

       /*capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "8524e42f7d94");
       //capabilities.setCapability("appPackage", "wta.com.picatrebax");
       capabilities.setCapability("appWaitActivity", "wta.com.picatrebax.activity.AuthActivity");
       capabilities.setCapability("noReset", "true");
       capabilities.setCapability(MobileCapabilityType.APP, "/home/dmytro/Desktop/app-UIdebug.apk");
       //capabilities.setCapability("autoAcceptAlerts", true);
       capabilities.setCapability("autoGrantPermissions", "true");*/

       /*try {
           AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                   new URL("http://hub.browserstack.com/wd/hub"), caps);
           //driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       } catch (MalformedURLException e){
           System.out.println(e.getMessage());
       }*/

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);
        //driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        driver.findElement(By.id("wta.com.picatrebax:id/googleSignInButton")).click();
        //Thread.sleep(5000);
        //List<AndroidElement> account = (List<AndroidElement>) driver.findElementsById("com.google.android.gms:id/account_display_name");
        //account.get(0).click();
        driver.findElement(By.id("wta.com.picatrebax:id/next")).click();
        driver.findElement(By.id("wta.com.picatrebax:id/skip")).click();
        Thread.sleep(5000);
        List<AndroidElement> course = (List<AndroidElement>) driver.findElementsByClassName("android.widget.ImageView");
        course.get(4).click();
        List<AndroidElement> theme = (List<AndroidElement>) driver.findElementsById("wta.com.picatrebax:id/cardView");
        theme.get(1).click();

        MobileElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceIdMatches(\".*wta.com.picatrebax:id/next.*\"))"));
        element.click();
        driver.findElement(By.id("wta.com.picatrebax:id/firstAnswer")).click();
        driver.findElement(By.id("wta.com.picatrebax:id/secondAnswer")).click();
        driver.findElement(By.id("wta.com.picatrebax:id/answer")).click();
        driver.findElement(By.id("wta.com.picatrebax:id/tryAgainButton")).click();
        Thread.sleep(5000);
        Set<String> contextNames = driver.getContextHandles();
        //Thread.sleep(5000);
        System.out.println(contextNames);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//android.view.View[@text='Close']")).click();



        //driver.context((String) contextNames.toArray()[1]);
        //driver.navigate().back();
        //driver.findElement(By.id("close-btn")).click();
        //driver.context("NATIVE_APP");
        //driver.findElement(By.xpath("//*[text()='Close']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.alertIsPresent());
        //Thread.sleep(15000);
        //driver.close();
        //driver<WebElement>.findElement();

        //System.out.println(driver.getCurrentUrl());

        //driver.findElementsByXPath("//*[text()='Close']").click();
        //el.click();
        //WebElement closebutton = driver.findElement(By.xpath("//*[text()='Close']"));
        //closebutton.click();


       /*if (!closebutton.isEnabled()) {

           driver.findElement(By.xpath("//*[text()='Close']")).click();
       }*/


        //WebElement nextButton = driver.findElement(By.id("wta.com.picatrebax:id/next"));

       /*TouchActions action = new TouchActions(driver);
       action.scroll(element,10,100);
       action.perform();
       nextButton.click();*/
        driver.quit();

    }
}
