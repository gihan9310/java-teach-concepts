pipeline {
    agent any
    tools {
       maven 'maven_home'
    }
    stages{
       stage('Build Maven'){
           steps{
               checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/gihan9310/java-teach-concepts']]])
               sh 'mvn clean install'
           }
       }
       stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t gihansoft/aws-app .'
                }
            }
       }
       stage('push image into hub'){
           steps{
                script{
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u gihansoft -p HBKhbkdhl99'
                    }
                    sh 'docker push gihansoft/aws-app'
                }
           }
       }

    }
}
