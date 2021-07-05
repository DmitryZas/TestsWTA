import driver.DriverFacade;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
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

        //Delete user
        RestAssured.baseURI = "https://firestore.googleapis.com/v1/projects/what-tha-art/databases/(default)/documents/users/";
        RequestSpecification request = RestAssured.given();
        request.params("access_token","8c57567b9cbadfa3220653fa292585303f805f88");
        request.header("Content-Type", "application/json");
        Response response = request.delete(RestAssured.baseURI + "112983460009403738430");

        int statusCode = response.getStatusCode();
        System.out.println(response.asString());
        Assert.assertEquals(statusCode, 200);

        String jsonString =response.asString();
        Assert.assertTrue(jsonString.contains("{}"));
    }

    @Test
    public void answersInVenusCourse(){
        driver.tapElement(auth.googleSignInButton);
        if (driver.isElementPresent(auth.googleAccountButton)) {
            driver.tapElement(auth.googleAccountButton);
        }
        driver.wait(2);
        driver.tapElement(auth.nextButtonTutorial);
        driver.tapElement(auth.skipButtonTutorial);
        driver.wait(2);
        driver.chooseElement(question.course, 5);
        driver.wait(2);
        driver.tapElement(question.startCourseButton);

        driver.chooseElement(question.theme, 0);
        driver.wait(2);
        driver.tapNextTheoryButton();
        driver.tapElement(question.fourthAnswer);
        driver.wait(5);
        driver.tapElement(question.nextButton);
        driver.wait(2);
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.wait(2);
        //driver.tapElement(question.nextButton);
        driver.tapNextTheoryButton();
        driver.tapNextTheoryButton();
        driver.wait(2);
        driver.chooseImageAnswer(question.imageAnswer, 0);
        driver.wait(2);
        driver.tapCheckButton();
        driver.wait(5);
        driver.tapNextTheoryButton();

        driver.wait(2);
        driver.chooseElement(question.theme, 1);
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.fourthAnswer);
        driver.tapCheckButton();
        driver.tapNextTheoryButton();
        driver.tapElement(question.firstAnswer);
        driver.tapElement(question.thirdAnswer);
        driver.tapCheckButton();
        driver.wait(5);
        driver.tapNextTheoryButton();

        driver.wait(2);
        driver.chooseElement(question.theme, 2);
        driver.tapNextTheoryButton();
        driver.chooseImageAnswer(question.imageAnswer, 1);
        driver.tapElement(question.checkBox);
        driver.chooseImageAnswer(question.imageAnswer, 2);
        driver.tapElement(question.checkBox);
        driver.tapCheckButton();
        driver.tapNextTheoryButton();
        driver.tapElement(question.trueAnswer);
        driver.tapNextTheoryButton();
        driver.tapElement(question.falseAnswer);
        driver.tapNextTheoryButton();
        for (int i = 0; i < question.rightAnswers.length; i++) {
            driver.chooseAnswer(question.rightAnswers[i]);
            System.out.println(question.rightAnswers[i]);
        }
        driver.tapCheckButton();
        driver.tapElement(question.nextButton);
        driver.tapElement(question.nextButton);
        //driver.tapNextTheoryButton();

        driver.chooseElement(question.theme, 3);
        driver.wait(2);
        driver.tapNextTheoryButton();
        for (int i = 0; i < question.rightAnswers.length; i++) {
            driver.chooseAnswer(question.rightAnswers[i]);
            System.out.println(question.rightAnswers[i]);
        }
        driver.chooseAnswer(question.answerA);
        driver.chooseAnswer(question.answer1);
        driver.chooseAnswer(question.answerB);
        driver.chooseAnswer(question.answer2);
        driver.chooseAnswer(question.answerC);
        driver.chooseAnswer(question.answer3);
        driver.chooseAnswer(question.answerD);
        driver.chooseAnswer(question.answer4);


        //driver.wait(2);
        driver.tapCheckButton();
        driver.tapElement(question.navbarNextButton);
        driver.tapElement(question.firstAnswer);
        //driver.wait(2);
        driver.tapNextTheoryButton();
        driver.tapNextTheoryButton();
        driver.tapElement(question.secondAnswer);
        driver.tapNextTheoryButton();
        driver.tapNextTheoryButton();
        driver.chooseImageAnswer(question.imageAnswer, 0);
        driver.tapCheckButton();
        //driver.wait(5);
        driver.tapElement(question.navbarNextButton);

        driver.wait(2);
        driver.chooseElement(question.theme, 4);
        driver.tapNextTheoryButton();
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.thirdAnswer);
        driver.tapCheckButton();
        driver.tapElement(question.navbarNextButton);
        driver.tapElement(question.secondAnswer);
        driver.tapElement(question.fourthAnswer);
        driver.tapCheckButton();
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
        driver.StopDriver();
        }
}
