package com.solvd.posteducation.cucumber.carina.demo.runner;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/checkout.feature",
        glue = "com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.checkoutsteps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"})
public class CheckoutCucumberTest extends CucumberBaseTest {
}
