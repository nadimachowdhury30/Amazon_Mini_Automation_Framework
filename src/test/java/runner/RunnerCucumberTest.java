
package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target/failed_scenarios.txt"
        },
        monochrome = true
)
public class RunnerCucumberTest extends AbstractTestNGCucumberTests {
}
