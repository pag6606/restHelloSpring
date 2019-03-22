pipeline {
  agent any
  stages {
    stage('Inicio') {
      steps {
        echo 'Arranque de pipeline'
      }
      post{
        always {
          echo "Resultado:"
        }
        failure {
          echo "Falla"
        }
        sucess {
          echo "exito !!"
        }
      }
    }
    stage('Paso 2') {
      steps {
        echo 'Paso dos'
      }
      post {
        always(dir) {
          cleanWS
        }
      }
    }
  }
}
