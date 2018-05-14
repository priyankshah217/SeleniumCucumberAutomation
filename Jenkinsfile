node{
    stage('Checkout') {
        steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'CleanBeforeCheckout']], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '22171b56-3429-48ab-a329-e29da327cde0', url: 'https://github.com/priyankshah217/SeleniumCucumberAutomation.git']]])
        }
    }
}