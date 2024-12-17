package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
glue= {"stepDefenitions","hooks"},
plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})
public class TestRunner {


}
	

