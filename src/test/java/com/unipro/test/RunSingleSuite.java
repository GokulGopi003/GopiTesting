package com.unipro.test;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(features = "target/test-classes", monochrome = true, tags = "@apirl10", plugin = {
        "pretty", "html:target/cucumber-report/single",
        "json:target/cucumber-report/single/cucumber.json",
        "rerun:target/cucumber-report/single/rerun.txt"},
        glue = "com.unipro.test")
public class RunSingleSuite extends AbstractTestNGCucumberTests {
}
