package com.kbtem.project_x.pages;

import com.kbtem.project_x.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindAll({@FindBy(xpath = "//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/section/div/div/div[*]/div/div/div/div/div[2]")})
    public List<WebElement> searchResults;
}
