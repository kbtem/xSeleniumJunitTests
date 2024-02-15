package com.kbtem.amazon_project.pages;

import com.kbtem.amazon_project.utils.ConfigurationReader;
import com.kbtem.amazon_project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


    @FindBy(linkText = "Create account")
    public WebElement createAccountBtn;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div/div/div[3]/div[5]/a/div/span")
    public WebElement signInBtn;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[1]/div/div/div[3]/div[2]")
    public WebElement signInWithApple;

    @FindBy(xpath = "//*[@id=\"container\"]/div/div[2]/div[1]/div[1]")
    public WebElement signInWithGoogle;

    @FindBy(className = "r-30o5oe")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "(//div[@role='button' and @tabindex='0']//span[contains(@class, 'css-1qaijid')])[4]")
    public WebElement nextButton;

    @FindBy(xpath = "//div[@data-testid='LoginForm_Login_Button']")
    public WebElement loginBtn;

    @FindBy(css = "div[role='alert'][data-testid='toast'] span")
    public WebElement errorMessage;

    @FindBy(css = "\"input[data-testid='ocfEnterTextTextInput'][name='username']\"")
    public WebElement passwordResetUsernameInput;

    @FindBy(css = "\"div[data-testid='ocfEnterTextNextButton']\"")
    public WebElement getPasswordResetNextBtn;


    @FindBy(xpath = "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div[1]")
    public WebElement confirmationCodeNextBtn;

    @FindBy(xpath = "//*[@id=\"layers\"]/div[2]/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]")
    public WebElement confirmationCodeCancelBtn;




    public void login(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("twitter.url"));
        // 1. Clicks sign in button on home page.
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
        String loginUrl = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().get(loginUrl);
        // 2. Puts in username.
        wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
        usernameInput.sendKeys(username);
        // 3. Clicks next button.
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        // 4. Puts in password.
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        // 5. Clicks log in button.
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();

    }

}
