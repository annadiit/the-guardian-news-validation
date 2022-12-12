# the-guardian-news-validation

This is the test automation framework developed to test if the first article presented on the <a href = "https://www.theguardian.com/tone/news" target="_blank">Guardian</a> is not fake. This automation framework is developed using Selenium, Cucumber, Java and Maven.
There is a single feature file with five scenarios. Each scenario has three steps. 

## Installation

# Pre-requisite:

Install next software on your machine:
1. Install JDK 1.8 and set path
2. Install <a href="https://maven.apache.org/download.cgi" target="_blank">Maven</a> and set path
3. Install <a href = "https://www.jetbrains.com/idea/download/#section=mac" target="_blank">Intellij</a> (or Eclipse)
4. Add plugins to Intellij (or Eclipse): Maven and Cucumber
5. Download Chrome driver 


# Get the code

Git:

    git clone https://github.com/annadiit/the-guardian-news-validation.git
    cd the-guardian-news-validation

## Run Feature Scenarios

Navigate to your project directory from terminal and run following commands:

    maven test

This runs Cucumber features using Cucumber's JUnit Platform Engine. The `Suite`
annotation on the `RunTests` class tells JUnit to kick off Cucumber.
