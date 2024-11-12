pipeline {
    agent any

    environment {
        ENVIRONMENT = "${params.ENVIRONMENT ?: 'staging'}"
        DOCKER_IMAGE = "jpsbat/cursos:${ENVIRONMENT}"
        DOCKER_CREDENTIALS_ID = 'jpsbat'
    }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['staging', 'production'], description: 'Selecionar o ambiente de deploy')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    bat 'mvn clean package -Dspring.profiles.active=test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                        bat "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    if (ENVIRONMENT == 'staging') {
                        bat "docker-compose -f docker-compose-staging.yml up -d"
                    } else if (ENVIRONMENT == 'production') {
                        bat "docker-compose -f docker-compose-prod.yml up -d"
                    }
                }
            }
        }
    }

    post {
        always {
            script {
                if (ENVIRONMENT == 'staging') {
                    echo "Deploy realizado no ambiente de staging."
                } else if (ENVIRONMENT == 'production') {
                    echo "Deploy realizado no ambiente de production."
                }
            }
        }
    }
}
