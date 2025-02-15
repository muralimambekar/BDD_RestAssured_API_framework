package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", 
				 glue= {"stepDefinitions"}, 
				 plugin= {"pretty","html:test-output.html"}, 
				 monochrome=true,
				 dryRun = false)

public class runner {

}
