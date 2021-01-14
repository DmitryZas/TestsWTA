import driver.DriverFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import selectors.AuthPage;
import selectors.QuestionPage;

public class VenusCourseTests {
    private DriverFacade driver;
    private QuestionPage question;
    private AuthPage auth;

    @Before
    public void setup(){
        driver = new DriverFacade();
        question = new QuestionPage();
        auth = new AuthPage();
    }

    @Test
    public void answersInVenusCourse() {
        driver.tapElement(auth.googleSignInButton);
        driver.tapElement(auth.nextButton);
        driver.tapElement(auth.skipButton);
        driver.chooseCourse(question.course);
        driver.chooseTheme(question.theme, 4);
        driver.findBottomElement();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.checkButton);
        driver.tapElement(question.tryAgainButton);
        driver.getContext();
    }

    @After
    public void end(){
        driver.StopDriver();}
}
