import driver.DriverFacade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
    public void answersInVenusCourse() throws InterruptedException {
        driver.tapElement(auth.googleSignInButton);
        driver.tapElement(auth.nextButtonTutorial);
        driver.tapElement(auth.skipButtonTutorial);
        driver.chooseElement(question.course, 4);
        driver.tapElement(question.startCourseButton);

        /*driver.chooseTheme(question.theme, 0);
        driver.tapNextTheoryButton();
        driver.tapElement(question.fourthAnswer);
        driver.wait(5);
        driver.tapElement(question.nextButton);
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.wait(2);
        driver.tapElement(question.nextButton);
        driver.tapNextTheoryButton();
        driver.wait(2);
        driver.tapElement(question.firstImage);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();

        driver.chooseTheme(question.theme, 1);
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.fourthAnswer);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.thirdAnswer);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();

        driver.chooseTheme(question.theme, 2);
        driver.tapNextTheoryButton();
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.thirdAnswer);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();
        driver.tapElement(question.trueAnswer);
        driver.tapNextTheoryButton();
        driver.tapElement(question.falseAnswer);
        driver.tapNextTheoryButton();
        driver.tapElement(question.answerA);
        driver.tapElement(question.answer1);
        driver.tapElement(question.answerB);
        driver.tapElement(question.answer2);
        driver.tapElement(question.answerC);
        driver.tapElement(question.answer3);
        driver.tapElement(question.answerD);
        driver.tapElement(question.answer4);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();*/

        driver.chooseElement(question.theme, 3);
        driver.tapNextTheoryButton();

        driver.tapElement(question.answerA);
        driver.tapElement(question.answer1);
        driver.tapElement(question.answerB);
        driver.tapElement(question.answer2);
        driver.tapElement(question.answerC);
        driver.tapElement(question.answer3);
        driver.tapElement(question.answerD);
        driver.tapElement(question.answer4);

        driver.wait(2);
        driver.checkButton();
        driver.tapElement(question.navbarNextButton);
        driver.tapElement(question.firstAnswer);
        driver.tapNextTheoryButton();
        driver.tapNextTheoryButton();
        driver.tapElement(question.secondAnswer);
        driver.tapNextTheoryButton();
        driver.tapNextTheoryButton();
        driver.chooseImageAnswer(question.imageAnswer, 0);
        driver.tapElement(question.checkButton);
        driver.wait(5);
        driver.tapElement(question.navbarNextButton);

        driver.wait(2);
        driver.chooseElement(question.theme, 4);
        driver.tapNextTheoryButton();
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.thirdAnswer);
        driver.wait(2);
        driver.tapElement(question.checkButton);
        driver.tapElement(question.navbarNextButton);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.fourthAnswer);
        driver.tapElement(question.checkButton);
        driver.tapNextTheoryButton();
        driver.tapElement(question.trueAnswer);
        driver.tapNextTheoryButton();
        driver.tapElement(question.falseAnswer);
        driver.tapElement(question.navbarNextButton);










        //driver.tapElement(question.tryAgainButton);
        //driver.getContext();
    }

    @After
    public void end(){
        driver.StopDriver();}
}
