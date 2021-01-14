import driver.DriverFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.QuestionPage;

public class VenusCourseTests {
    private DriverFacade driver;
    private QuestionPage question;

    @Before
    public void setup(){
        driver = new DriverFacade();
        question = new QuestionPage();
    }

    @Test
    public void answersInVenusCourse() throws InterruptedException {
        driver.tapElement(question.googleSignInButton);
        driver.tapElement(question.nextButton);
        driver.tapElement(question.skipButton);
        driver.chooseCourse("android.widget.ImageView");
        driver.chooseTheme("wta.com.picatrebax:id/cardView");
        driver.findBottomElement();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.checkButton);
        driver.tapElement(question.tryAgainButton);
        Thread.sleep(5000);
        driver.getContext();
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//android.view.View[@text='Close']")).click();
    }

    @After
    public void end(){
        driver.StopDriver();}
}
