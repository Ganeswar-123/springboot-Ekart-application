pipeline{
    agent any
    stages {
        stage('Git Checkout'){
            steps{
                script{
                    git credentialsId: 'github', url: 'https://github.com/Ganeswar-123/springboot-Ekart-application.git'
                }
            }
        }
    }
}