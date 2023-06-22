FROM maven:3.6.3-jdk-8
COPY src/test/java/alltests/apitest home/apiframework1/src
COPY extentreports/AutomationTestNGExtentReport.html home/apiframework1/index.html
COPY pom.xml home/apiframework1/pom.xml
COPY src/test/resources/testng.xml home/apiframework1/testng.xml
WORKDIR  home/apiframework1
ENTRYPOINT mvn clean test