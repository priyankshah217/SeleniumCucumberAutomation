node {
    def buildResult = 'STARTED'
    stage('Checkout') {
        echo "***** Checkout from github *****"
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CleanBeforeCheckout']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '22171b56-3429-48ab-a329-e29da327cde0', url: 'https://github.com/priyankshah217/SeleniumCucumberAutomation.git']]])
    }

    try {
        stage('Integration Tests') {
            echo "***** Running Integration Tests *****"
            sh "./gradlew clean e2e -Dbrowser.type=firefox"
            buildResult = 'SUCCESSFUL'
        }
    } catch (Exception e) {
        buildResult = 'FAILED'
        echo "Failure in Build and test"
        echo "Continuing to Archive Artifacts stage"
    }

    stage("Archive Artifacts") {
        echo "***** Archive Artifacts and Test Results *****"
        archiveArtifacts artifacts: 'build/reports/**/*.*',
                fingerprint: true
    }

    stage("Publish Reports") {
        echo "***** Publish Reports *****"
        cucumber fileIncludePattern: '**/*.json', jsonReportDirectory: 'build/reports', sortingMethod: 'ALPHABETICAL'
    }

    if (buildResult == 'FAILED') {
        manager.buildFailure()
    }
}