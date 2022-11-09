pipeline {
    agent any
    tools {
       maven 'maven_home'
    }
    stages{
       stage('Build Maven'){
           steps{
               checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gihan9310/java-teach-concepts']]])
               bat 'mvn clean install'
           }
       }
       stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t gihansoft/aws-app .'
                }
            }
       }
       stage('pubat image into hub'){
           steps{
                script{
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhubpwd')]) {
                        bat 'docker login -u gihansoft -p HBKhbkdhl99'
                    }
                    bat 'docker pubat gihansoft/aws-app'
                }
           }
       }

    }
}
