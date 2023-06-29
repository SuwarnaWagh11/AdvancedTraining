C:\Jenkins>java -jar jenkins.war --httpPort=9090

Now start both the demons - sonarqube and reportportal. and now load the below url
http://localhost:8094 - sonarqube
http://localhost:9090/ - jenkins
http://localhost:8080/ - reportportal - login may happen after 5-10 min. 

You can check logs for sonarqube using below cmd:
docker logs -f sonarqube3091

below steps need to do to create new daemon
C:\report_portal>docker run --name sonarqube3091 -h sonarqube3091 -p 8094:9000 -d sonarqube

TO run maven project in cmd line
C:\AdvancedTraining>mvn package sonar:sonar

browser stack--
suwarnawagh_2RNiFk
6KnfFqV9HehN7odumuxE

https://suwarnawagh_2RNiFk:6KnfFqV9HehN7odumuxE@hub-cloud.browserstack.com/wd/hub
---------------------Deploy report portal with docker-----------------------------

Refer video - https://www.youtube.com/watch?v=Wxb4JH7p1B4 - Report Portal Installation

Make sure Docker Engine & Compose is installed.

Download latest report portal Docker-compose.yml file save it in folder - C:\report_portal\docker-compose.yml
https://github.com/reportportal/reportportal/blob/master/docker-compose.yml
Also create the directory C:\report_portal\data\elasticsearch.

Set vm.max_map_count to atleast 262144
wsl -d docker-desktop
sysctl -w vm.max_map_count=262144

To start the server
C:\report_portal>docker compose -p reportportal up -d --force-recreate

Now check if it up and running using below link
localhost:8080 
userid 	- 	superadmin
pwd 	- 	erebus

default\1q2w3e
superadmin\erebus.

How to stop server running- 
C:\report_portal>docker compose -p reportportal stop

Youtube video for reference
How to Get Started with ReportPortal.io Automation Dashboard -  https://www.youtube.com/watch?v=By41MuZDh70

Jenkins

http://localhost:9090/

admin - 123456789

Sonarqube
C:\report_portal>docker run --name sonarqube3091 -h sonarqube3091 -p 8094:9000 -d sonarqube
0bcfc5726607280c596e7403b56bbbcaf0eedf6f9e7450cade4e04525edea7e5
http://localhost:8094/
admin - 123456789

docker logs -f sonarqube3091

token generated for 90 days
sonartoken
squ_9279444d69adfb8cc5568eb18c7dd440357a91a1

docker pull khipu/openjdk17-alpine

docker pull maven:3.6.1-jdk-11-slim

git remote add origin https://github.com/SuwarnaWagh11/APIAutomation.git

git remote add origin https://SuwarnaWagh@dev.azure.com/SuwarnaWagh/AdvancedTrainingProgram/_git/AdvancedTrainingProgram
git push -u origin --all

git remote add origin https://SuwarnaWagh@dev.azure.com/SuwarnaWagh/AdvancedTrainingProgram/_git/AdvancedTrainingProgram
git push -u origin --all
-----------------------------------------

Create Cucumber Junit framework - tests and execute them and generate report. 
https://www.youtube.com/watch?v=4XTPsL5mDV0
https://www.youtube.com/watch?v=vjNHxIG9X6E
-----------------------------------------------------------

http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard

http://localhost:8080/api/

8bb82a7d-a573-419e-9cce-c2419f308802

https://www.youtube.com/watch?v=P5CLXIC7x5c - Selenium 4 Grid Tutorial with examples - Parallel execution in Remote Machines

C:\Selenium Grid>Java -jar selenium-server-4.9.1.jar hub
10:54:28.942 INFO [LoggingOptions.configureLogEncoding] - Using the system default encoding
10:54:28.946 INFO [OpenTelemetryTracer.createTracer] - Using OpenTelemetry for tracing
10:54:29.464 INFO [BoundZmqEventBus.<init>] - XPUB binding to [binding to tcp://*:4442, advertising as tcp://192.168.1.11:4442], XSUB binding to [binding to tcp://*:4443, advertising as tcp://192.168.1.11:4443]
10:54:29.525 INFO [UnboundZmqEventBus.<init>] - Connecting to tcp://192.168.1.11:4442 and tcp://192.168.1.11:4443
10:54:29.547 INFO [UnboundZmqEventBus.<init>] - Sockets created
10:54:30.561 INFO [UnboundZmqEventBus.<init>] - Event bus ready
10:54:32.116 INFO [Hub.execute] - Started Selenium Hub 4.9.1 (revision eb2032df7f): http://192.168.1.11:4444

adding node
step 2:
C:\Selenium Grid>java -jar selenium-server-4.9.1.jar node --detect-drivers true
11:17:51.929 INFO [LoggingOptions.configureLogEncoding] - Using the system default encoding
11:17:51.934 INFO [OpenTelemetryTracer.createTracer] - Using OpenTelemetry for tracing
11:17:52.118 INFO [UnboundZmqEventBus.<init>] - Connecting to tcp://0.0.0.0:4442 and tcp://0.0.0.0:4443
11:17:52.178 INFO [UnboundZmqEventBus.<init>] - Sockets created
11:17:53.184 INFO [UnboundZmqEventBus.<init>] - Event bus ready
11:17:53.602 INFO [NodeServer.createHandlers] - Reporting self as: http://192.168.1.11:5555
11:17:54.302 INFO [NodeOptions.getSessionFactories] - Detected 8 available processors
11:17:54.315 INFO [NodeOptions.discoverDrivers] - Driver(s) already present on the host: 3
11:17:54.350 INFO [NodeOptions.report] - Adding Edge for {"browserName": "MicrosoftEdge","ms:edgeOptions": {"args": [ "--remote-allow-origins=*" ] }, "platformName": "Windows 10" } 8 times (Host)
11:17:54.352 INFO [NodeOptions.report] - Adding Firefox for {"browserName": "firefox","platformName": "Windows 10"} 8 times (Host)
11:17:54.353 INFO [NodeOptions.report] - Adding Chrome for {"browserName": "chrome","goog:chromeOptions": {"args": [ "--remote-allow-origins=*" ] }, "platformName": "Windows 10" } 8 times (Host)
11:17:54.383 INFO [Node.<init>] - Binding additional locator mechanisms: relative
11:17:54.919 INFO [NodeServer$1.start] - Starting registration process for Node http://192.168.1.11:5555
11:17:54.920 INFO [NodeServer.execute] - Started Selenium node 4.9.1 (revision eb2032df7f): http://192.168.1.11:5555
11:17:54.946 INFO [NodeServer$1.lambda$start$1] - Sending registration event...
11:17:55.307 INFO [NodeServer.lambda$createHandlers$2] - Node has been added



Started hub				::   	java -jar selenium-server-4.9.1.jar hub
my hub					::     	http://192.168.1.11:4444
adding node on 
my Hub(same machine)	::  	java -jar selenium-server-4.9.1.jar node -–detect-drivers true
adding node on my Hub
(diff. physical machine)::		java -jar selenium-server-4.9.1.jar node -–detect-drivers true –publish-events tcp:// 192.168.1.11:4442 –subscribe-events tcp:// 192.168.1.11:4443

-----------------------------
This field follows the syntax of cron (with minor differences). Specifically, each line consists of 5 fields separated by TAB or whitespace:
MINUTE HOUR DOM MONTH DOW

every minute" when you say "* * * * *"? Perhaps you meant "H * * * *" to poll once per hour
* * * * *
H * * * *
H H(0-7) * * * means some time between 12:00 AM (midnight) to 7:59 AM. You can also use step intervals with H, with or without ranges.
H/15 * * * *  means Every fifteen minutes 
H(0-29)/10 * * * * Every ten minutes in the first half of every hour (three times, perhaps at :04, :14, :24):
once a day on the 1st and 15th of every month except December

triggers{ cron('H H * * *') }

target/cucumber-reports/MyHtmlReport.html

publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Target_Reports', reportFiles: 'AutomationExtentReport.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])

 publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Target_Reports', reportFiles: 'AutomationTestNGExtentReport.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
 publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'BDDFramework/target/cucumber-reports', reportFiles: 'MyHtmlReport.html', reportName: 'BDD HTML Report', reportTitles: '', useWrapperFileDirectly: true])
  


-------------failed with below dockerfile-

FROM maven:3.6.3-jdk-8
COPY src home/apiframework/src
COPY index.html home/apiframework/pom.xml
COPY testng.xml home/apiframework/testng.xml
WORKDIR  home/apiframework/pom
ENTRYPOINT mvn clean test
----------------passed with below file-----------------
I have all set up, running building and executing tests pom.xml - with java 11.

I found below image - https://hub.docker.com/_/maven/tags?page=27
docker pull maven:3.6.1-jdk-11-slim - executing in cmd - working fine 
below dockerfile prepared , format is in (Keyword src_destination target_destingation)

FROM maven:3.6.1-jdk-11-slim
COPY src home/apiframework/src
COPY index.html home/apiframework/pom.xml
COPY testng.xml home/apiframework/testng.xml
WORKDIR  home/apiframework/pom
ENTRYPOINT mvn clean test

open terminal in Intellij, try running command docker- it should give some docker command & help info

Now make sure that you are in the same directry where the dockerfile is present.

1. docker build -t myfirstimage:0.1 .
2. open cmd & type command
	docker images
3. make sure your image is present in the list.
4. run your image
	docker run myfirstimage:0.1
5. Check whether your maven clean install build is executing & tests are passing
6. docker ps 
7. make sure your image is present in the list with containierID, IMAGE, COMMAND,CREATED,STATUS,PORTS,NAMES
8. NOW WE WILL CREATE OUR OWN IMAGE USING THIS CONTAINERID-878asc6578df
9. TYPE BELOW command
	docker commit 878asc 
10. now give name to that image 
	docker images 
	REPOSITORY,TAG,IMAGEID,CREATED,SIZE
	
11. docker tag -t IMAGEID suwarnawagh/java11-mvn3.6.1-tests:latest
12. docker images 
check if your image has name we have given - suwarnawagh/java11-mvn3.6.1-tests:latest
13. this is our base image now
14. go to the terminal intellij & we will create final image now.
15. update dockerfile with our image name in FROM suwarnawagh/java11-mvn3.6.1-tests:latest
16. docker build -t suwarnawagh/apitestsimage:latest
17. go to cmd and run
docker run suwarnawagh/apitestsimage:latest
18. now push this to docker repository
19.run in cmd 
docker login
20. docker push suwarnawagh/apitestsimage:latest

check docker hub, your image should be present.

sauceLabs
28d87cd0-8d3a-4928-83f5-fcf8531a1890

Ondemand URL
https://oauth-suwarnawagh11-4520d:28d87cd0-8d3a-4928-83f5-fcf8531a1890@ondemand.eu-central-1.saucelabs.com:443/wd/hub

followed steps on the page for tunnel set up: https://app.eu-central-1.saucelabs.com/tunnels

executed this in cmd
sc-4.9.1-win32\sc-4.9.1-win32\bin>sc -u oauth-suwarnawagh11-4520d -k 28d87cd0-8d3a-4928-83f5-fcf8531a1890 --region eu-central --tunnel-name oauth-suwarnawagh11-4520d_tunnel_name

http://localhost:8080/ui/#login

