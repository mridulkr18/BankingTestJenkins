pipeline{
    agent any
    stages{
        stage("build"){
             steps{
               bat "mvn package"
            }
        }
        stage("capture"){
            steps{
                archiveArtifacts '**/target/*.jar'
                junit testResults: '**/target/surefire-reports/TEST*.xml'
            }
        }
    }
        post{
            always{
                echo "I am here in post-always"
            }
        }
    
}
