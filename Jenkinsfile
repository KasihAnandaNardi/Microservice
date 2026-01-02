pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Images') {
            steps {
                withCredentials([
                    string(credentialsId: 'SMTP_USERNAME', variable: 'SMTP_USERNAME'),
                    string(credentialsId: 'SMTP_PASSWORD', variable: 'SMTP_PASSWORD'),
                    string(credentialsId: 'SMTP_FROM', variable: 'SMTP_FROM')
                ]) {
                    bat '''
                        docker compose build
                    '''
                }
            }
        }

        stage('Stop Old Containers') {
            steps {
                bat 'docker compose down --remove-orphans'
            }
        }

        stage('Run Containers') {
            steps {
                withCredentials([
                    string(credentialsId: 'SMTP_USERNAME', variable: 'SMTP_USERNAME'),
                    string(credentialsId: 'SMTP_PASSWORD', variable: 'SMTP_PASSWORD'),
                    string(credentialsId: 'SMTP_FROM', variable: 'SMTP_FROM')
                ]) {
                    bat '''
                        docker compose up -d
                    '''
                }
            }
        }
    }
}
