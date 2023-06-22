pipeline {
    agent any
    environment {
        PATH = "C:/Maven/apache-maven-3.9.1/bin/mvn:$PATH"
    }
    triggers {
        pollSCM 'H/2 * * * *'
    }
    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('git clone') {
            steps {
                git url: 'https://github.com/SuwarnaWagh11/AdvancedTraining.git', branch: 'main'
            }
        }
        stage('build') {
            steps {
                sh "mvn clean install"
            }
        }
    }
    post {
        success {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'Target_Reports', reportFiles: 'AutomationTestNGExtentReport.html', reportName: 'Extent Report', reportTitles: '', useWrapperFileDirectly: true])
            cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', jsonReportDirectory: 'BDDFramework/target/cucumber-reports', pendingStepsNumber: -1, reportTitle: 'Cucumber Json Report', skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
        }
    }
}
