pipeline {
    agent any
    environment{
        DOCKER_CRED = credentials('dockerhub-pwd-id')
    }
    tools{
        maven 'maven_3.8.6'
    }
    stages{
        stage('Perform Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/hdhage/sb-devops-automation']]])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker image'){
            steps{
                script{
                    sh 'docker build -t hemantdhage/devops-integration .'
                }
            }
        }
        stage('Push image to DockerHub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd-id', variable: 'DOCKER_CRED')]) {
                        sh 'echo $DOCKER_CRED | docker login -u hemantdhage --password-stdin'
                        sh 'docker push hemantdhage/devops-integration'
                    }
                }
            }
        }
    }
}