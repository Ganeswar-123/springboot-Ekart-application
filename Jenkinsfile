pipeline {

  agent any

  stages {

    stage('Git Checkout') {

      steps {

        script {

          git branch: 'master', url: 'https://github.com/Ganeswar-123/springboot-Ekart-application.git'
        }
      }
    }
    stage('UNIT testing') {

      steps {

        script {

          bat 'mvn test'
        }
      }
    }
    stage('Integration testing') {

          steps {

            script {

              bat 'mvn verify -DskipUnitTests'
            }
           }
     }
     stage('Maven build') {

           steps {

             script {

               bat 'mvn clean install'
            }
            }
            }

  }
}