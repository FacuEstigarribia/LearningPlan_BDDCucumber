package com.solvd.posteducation.cucumber.carina.demo.runner;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/addproduct.feature",
        glue = "com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.addproductsteps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"})
public class AddProductCucumberTest extends CucumberBaseTest {
}
