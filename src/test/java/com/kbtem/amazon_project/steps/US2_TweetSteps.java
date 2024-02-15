package com.kbtem.amazon_project.steps;

import com.github.javafaker.Faker;
import com.kbtem.amazon_project.pages.HomePage;
import com.kbtem.amazon_project.pages.LoginPage;
import com.kbtem.amazon_project.utils.ConfigurationReader;
import com.kbtem.amazon_project.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US2_TweetSteps {

    Faker faker = new Faker();

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(3));

    @Given("User is logged in and the user is on the home page")
    public void userIsLoggedInAndTheUserIsOnTheHomePage() {
        // Using login method created to simplify login steps.
        loginPage.login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));
    }

    @And("User types in their tweet")
    public void userTypesInTheirTweet() {
        // User can not type in same tweet again. Java faker can be used to generate different message everytime.
        wait.until(ExpectedConditions.elementToBeClickable(homePage.tweetInput));
        homePage.tweetInput.sendKeys(faker.chuckNorris().fact());
    }

    @And("User clicks on post button")
    public void userClicksOnPostButton() {
        wait.until(ExpectedConditions.elementToBeClickable(homePage.postBtn));
        homePage.postBtn.click();
    }

    @Then("User should see their tweet on the page")
    public void userShouldSeeTheirTweetOnThePage() {
        wait.until(ExpectedConditions.visibilityOf(homePage.postedTweet));
        Assert.assertTrue(homePage.postedTweet.isDisplayed());
    }
}
