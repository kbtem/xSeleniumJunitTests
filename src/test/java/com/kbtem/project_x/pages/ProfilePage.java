package com.kbtem.project_x.pages;

import com.kbtem.project_x.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public ProfilePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[@class=\"css-1qaijid r-bcqeeo r-qvutc0 r-poiln3\"])[46]")
    public WebElement tweet;



}
