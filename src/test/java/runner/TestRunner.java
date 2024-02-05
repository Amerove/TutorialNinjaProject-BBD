package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="test/resources/features/",
				 glue={"stepdefinitions","hooks"},
		         plugin={"pretty",
		        		 "html:target/CucumberReports/CucumberReport.html",
		        		 "json:target/CucumberReports/CucumberReport.json",
		        		 "junit:target/CucumberReports/CucumberReport.junit",
		        		 },
	             tags="@all",
	             publish=true)
public class TestRunner {
	
	}