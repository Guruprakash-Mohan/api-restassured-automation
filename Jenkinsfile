pipeline {
    agent any

    tools {
        maven 'Maven-3.9.9'
        jdk 'JDK-17'
    }

    parameters {
        choice(
            name: 'TAG',
            choices: ['not @wip', '@smoke', '@negative', '@security', '@datatable'],
            description: 'Select which tests to run'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Guruprakash-Mohan/api-restassured-automation.git'
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test -Dcucumber.filter.tags=\"${params.TAG}\""
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Cucumber Test Report'
                ])
            }
        }
    }

    post {
        success {
            echo '✅ All tests passed!'
        }
        failure {
            echo '❌ Tests failed!'
        }
    }
}