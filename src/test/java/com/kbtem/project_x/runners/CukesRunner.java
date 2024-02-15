package com.kbtem.project_x.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/report.html",
                "rerun:target/rerun.txt"},
        glue = "com/kbtem/project_x/steps",
        features = "src/test/resources/features",
        dryRun = false,
        tags = ""
)
public class CukesRunner {
}
