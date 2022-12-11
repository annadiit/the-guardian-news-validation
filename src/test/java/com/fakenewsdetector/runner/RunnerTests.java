package com.fakenewsdetector.runner;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "",
        features = "src/test/resources/features/NewsValidation.feature",
        glue = "com.fakenewsdetector.definitions",
        plugin = {})
public class RunnerTests {

}
