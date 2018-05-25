# SeleniumCucumberAutomation
A sample test project for Cucumber based web automation.

#### To invoke automation:
##### Prerequisite
* Install jdk (1.8+)
* Install gradle

##### Steps to run automation locally
* Clone this repo using `git clone https://github.com/priyankshah217/SeleniumCucumberAutomation.git`
* Run this command `./gradlew clean e2e -Dbrowser.type=firefox`



#### To invoke automation Integration with Jenkins (Local setup):
##### Prerequisite
* Install jenkins (to invoke local jenkins setup) [https://jenkins.io/doc/book/installing/]

##### Steps to setup jenkins pipeline
* Create jenkins pipeline project
* Pull JenkinsFile from SCM (Please find below screenshot)

[![Local_Jenkins_Config.png](https://s9.postimg.cc/s7eeem9lb/Local_Jenkins_Config.png)](https://postimg.cc/image/c95oohfd7/)



#### To invoke dockerized/containerized tests:
##### Prerequisite
* Install docker [https://docs.docker.com/install/]
* Install docker-compose

##### Steps to run
*  Check out "dockerized_test" branch
*  Invoke `docker-compose up -d`
*  Report will be generated inside `/build/reports/cucumber/cucumber-html-reports/overview-features.html`

**Note:**
It will default run on firefox as browser, but it can be changed to "chrome" also.

##### References
* https://github.com/cucumber/cucumber-jvm/tree/master/examples/java-gradle
* https://jenkins.io/doc/book/pipeline/syntax/
* http://www.testautomationguru.com/selenium-webdriver-how-to-run-automated-tests-inside-a-docker-container/
* https://docs.docker.com/engine/reference/builder/
* https://docs.docker.com/compose/compose-file/
* https://github.com/niaquinto/docker-gradle

