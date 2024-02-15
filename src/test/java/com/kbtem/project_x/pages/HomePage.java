package com.kbtem.project_x.pages;

import com.kbtem.project_x.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/label/div[1]/div/div/div/div/div/div[2]/div/div/div/div")
    public WebElement tweetInput;

    @FindBy(xpath = "//div[@data-testid='tweetButtonInline']\n")
    public WebElement postBtn;


    @FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[5]/div/section/div/div/div[2]/div/div/article")
    public WebElement postedTweet;

}
