FROM maven:3.6.3-jdk-8
COPY AutomationFramework/src/test/java/alltests/apitest home/apiframework/src
COPY Target_Reports/AutomationTestNGExtentReport.html home/apiframework/index.html
COPY AutomationFramework/pom.xml home/apiframework/pom.xml
COPY AutomationFramework/src/test/resources/testng.xml home/apiframework/testng.xml
WORKDIR  home/apiframework
ENTRYPOINT mvn clean test