package com.solvd.posteducation.cucumber.carina.demo.runner;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/db_login.feature",
        glue = "com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.dbsteps",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"})
public class LoginCucumberDBTest extends CucumberBaseTest {
}
