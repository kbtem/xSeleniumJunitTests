package com.kbtem.amazon_project.pages;

import com.kbtem.amazon_project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


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
        // 1. Clicks sign in button on home page.
        signInBtn.click();
        // 2. Puts in username.
        usernameInput.sendKeys(username);
        // 3. Clicks next button.
        nextButton.click();
        // 4. Puts in password.
        passwordInput.sendKeys(password);
        // 5. Clicks log in button.
        loginBtn.click();

    }

}
