package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Saucedemo.feature",
        glue = "com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.LoginTest",
        plugin = {"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"})
public class LoginCucumberTest extends CucumberBaseTest { }
