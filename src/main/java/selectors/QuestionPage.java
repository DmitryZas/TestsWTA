package selectors;

import javafx.scene.control.Alert;
import org.openqa.selenium.By;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuestionPage {
    public By startCourseButton = By.id("wta.com.picatrebax:id/openCourseButton");
    public By firstAnswer = By.id("wta.com.picatrebax:id/firstAnswer");
    public By secondAnswer = By.id("wta.com.picatrebax:id/secondAnswer");
    public By thirdAnswer = By.id("wta.com.picatrebax:id/thirdAnswer");
    public By fourthAnswer = By.id("wta.com.picatrebax:id/fourthAnswer");
    public By imageAnswer = By.className("androidx.appcompat.app.ActionBar$Tab");
    public By trueAnswer = By.id("wta.com.picatrebax:id/trueAnswer");
    public By falseAnswer = By.id("wta.com.picatrebax:id/falseAnswer");
    public By answerA = By.id("wta.com.picatrebax:id/answerA");
    public By answer1 = By.id("wta.com.picatrebax:id/answer1");
    public By answerB = By.id("wta.com.picatrebax:id/answerB");
    public By answer2 = By.id("wta.com.picatrebax:id/answer2");
    public By answerC = By.id("wta.com.picatrebax:id/answerC");
    public By answer3 = By.id("wta.com.picatrebax:id/answer3");
    public By answerD = By.id("wta.com.picatrebax:id/answerD");
    public By answer4 = By.id("wta.com.picatrebax:id/answer4");
    public By checkButton = By.id("wta.com.picatrebax:id/answerButton");
    public By nextButton = By.xpath("//android.widget.Button[@text='NEXT']");
    public By tryAgainButton = By.id("wta.com.picatrebax:id/tryAgainButton");
    public By showHintButton = By.id("wta.com.picatrebax:id/hintButton");
    public By navbarPrevButton = By.id("wta.com.picatrebax:id/prevButton");
    public By navbarNextButton = By.id("wta.com.picatrebax:id/nextButton");
    public By watchAdButton = By.id("wta.com.picatrebax:id/adButton");
    public By buyHintButton = By.id("wta.com.picatrebax:id/coinButton");
    public By navbarIcons = By.id("wta.com.picatrebax:id/imageView"); //Add index
    public By questionText = By.id("wta.com.picatrebax:id/questionText");
    public By theoryWebViewScreen = By.className("android.webkit.WebView");
    public By course = By.className("android.widget.ImageView");
    public By theme = By.id("wta.com.picatrebax:id/cardView");
    public By finallCoinsText = By.id("wta.com.picatrebax:id/coinsText");
    public By finallExpText = By.id("wta.com.picatrebax:id/expText");

    public By[] rightAnswers = {
                answerA, answerB, answerC, answerD, answer1, answer2, answer3, answer4
    };

}
