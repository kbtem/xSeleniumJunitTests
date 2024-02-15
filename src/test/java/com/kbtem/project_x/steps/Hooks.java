package com.kbtem.project_x.steps;


import com.kbtem.project_x.utils.BrowserUtils;
import com.kbtem.project_x.utils.Driver;
import io.cucumber.java.After;

public class Hooks {


    @After
    public void tearDown() {
        BrowserUtils.browserSleep(3);
        Driver.getDriver().close();
    }


}
