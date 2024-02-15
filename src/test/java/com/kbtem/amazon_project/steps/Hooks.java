package com.kbtem.amazon_project.steps;


import com.kbtem.amazon_project.utils.BrowserUtils;
import com.kbtem.amazon_project.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @After
    public void tearDown() {
        BrowserUtils.browserSleep(3);
        Driver.getDriver().close();
    }


}
