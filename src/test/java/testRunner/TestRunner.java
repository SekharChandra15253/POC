package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Resources"
        ,glue = {"stepDefinations"},
        plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)


public class TestRunner {
    @AfterClass
    public static void writeExtentReport()
    {
        //Reporter.loadXMLConfig(new File());
    }
}
