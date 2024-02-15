package com.kbtem.project_x.steps;

import com.github.javafaker.Faker;
import com.kbtem.project_x.pages.HomePage;
import com.kbtem.project_x.pages.SearchPage;
import com.kbtem.project_x.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class US3_SearchSteps {

    SearchPage searchPage = new SearchPage();

    HomePage homePage = new HomePage();


    Faker faker = new Faker();

    String fakeName = faker.name().firstName();


    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));

    @When("the user enters a search query for another user")
    public void theUserEntersASearchQueryForAnotherUser() {
        wait.until(ExpectedConditions.visibilityOf(homePage.searchBox));

        homePage.searchBox.sendKeys(fakeName);
    }

    @And("clicks on the search button")
    public void clicksOnTheSearchButton() {
        homePage.searchBox.sendKeys(Keys.ENTER);
    }

    @Then("relevant user profiles should be displayed")
    public void relevantUserProfilesShouldBeDisplayed() {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        for (WebElement each : searchPage.searchResults) {
            Assert.assertTrue(each.getText().contains(fakeName));
        }


    }
}
