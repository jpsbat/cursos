pipeline {
    agent any
    environment {
        SPRING_PROFILE = 'staging'
        DOCKER_IMAGE = 'jpsbat/cursos:staging'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/jpsbat/cursos'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -P staging'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${DOCKER_IMAGE} ."
            }
        }
        stage('Push Docker Image') {
            steps {
                sh "docker push ${DOCKER_IMAGE}"
            }
        }
        stage('Deploy to Staging') {
            steps {
                sh "docker compose -f docker-compose.staging.yml up -d"
            }
        }
    }
}
