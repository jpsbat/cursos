pipeline {
    agent any

    environment {
        ENVIRONMENT = "${params.ENVIRONMENT ?: 'staging'}"Docker Hub
        DOCKER_IMAGE = "jpsbat/cursos:${ENVIRONMENT}"
    }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['staging', 'production'], description: 'Selecionar o ambiente de deploy')
    }

    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -P test'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                        sh "docker push ${DOCKER_IMAGE}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    if (ENVIRONMENT == 'staging') {
                        sh "docker-compose -f docker-compose-staging.yml up -d"
                    } else if (ENVIRONMENT == 'production') {
                        sh "docker-compose -f docker-compose-prod.yml up -d"
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
