package com.kbtem.amazon_project.steps;

import com.kbtem.amazon_project.pages.LoginPage;
import com.kbtem.amazon_project.utils.BrowserUtils;
import com.kbtem.amazon_project.utils.ConfigurationReader;
import com.kbtem.amazon_project.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.logging.Log;
import org.joda.time.Seconds;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class US1_Steps {

    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


    @Given("User is on the Twitter login page")
    public void userIsOnTheTwitterLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("twitter.url"));
    }

    @When("User enters valid username")
    public void userEntersValidUsername() {

        // 5 seconds timeout
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInBtn)).click();
        String loginUrl = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().get(loginUrl);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.usernameInput));
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));

    }

    @And("User clicks on the next button")
    public void userClicksOnTheNextButton() {
        System.out.println("Clicking next button");
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.nextButton));
        loginPage.nextButton.click();
        System.out.println("Next button clicked");
    }

    @And("User enters valid password")
    public void userEntersValidPassword() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordInput));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginBtn));
        loginPage.loginBtn.click();
    }

    @Then("User should see URl contains {string}")
    public void userShouldSeeURlContains(String expectedUrl) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);

    }


    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String invalidUsernameErrorMessage) {

        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));

        Assert.assertTrue(loginPage.errorMessage.isDisplayed());

        Assert.assertEquals(invalidUsernameErrorMessage, loginPage.errorMessage.getText());

    }


    @When("User enters {string} invalid username.")
    public void userEntersInvalidUsername(String invalidUsername) {

        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInBtn)).click();
        String loginUrl = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().get(loginUrl);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.usernameInput));
        loginPage.usernameInput.sendKeys(invalidUsername);

    }

    @And("User enters {string} invalid password.")
    public void userEntersInvalidPassword(String invalidPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.passwordInput));
        loginPage.passwordInput.sendKeys(invalidPassword);
    }

    @When("User clicks Sign in button")
    public void userClicksSignInButton() {
        wait.until(ExpectedConditions.visibilityOf(loginPage.signInBtn));
        loginPage.signInBtn.click();
    }

    @And("User should be directed to {string}")
    public void userShouldBeDirectedTo(String arg0) {
    }

    @And("User clicks Forgot password? button")
    public void userClicksForgotPasswordButton() {
    }

    @And("User should be redirected to {string}")
    public void userShouldBeRedirectedTo(String arg0) {
    }

    @And("User enters valid username to reset password")
    public void userEntersValidUsernameToResetPassword() {
    }

    @And("User click next on the password reset page")
    public void userClickNextOnThePasswordResetPage() {
    }

    @Then("User should see confirmation code page")
    public void userShouldSeeConfirmationCodePage() {
    }

    @And("User clicks on confirmation page next button")
    public void userClicksOnConfirmationPageNextButton() {
    }

    @Then("User should see message {string}")
    public void userShouldSeeMessage(String arg0) {
    }
}
