package com.unipro.test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "target/test-classes", tags = {"@Promotion2"}, monochrome = true, plugin = {
        "pretty", "html:target/cucumber-report/webapp",
        "json:target/cucumber-report/webapp/cucumber.json",
        "rerun:target/cucumber-report/webapp/rerun.txt"},
        glue = "com.unipro.test")
public class RunWebAppSuite extends AbstractTestNGCucumberTests {

}
