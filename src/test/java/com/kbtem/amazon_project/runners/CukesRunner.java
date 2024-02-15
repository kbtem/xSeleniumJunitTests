package com.kbtem.amazon_project.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber/report.html",
                "rerun:target/rerun.txt"},
        glue = "com/kbtem/amazon_project/steps",
        features = "src/test/resources/features",
        dryRun = false,
        tags = ""
)
public class CukesRunner {
}
