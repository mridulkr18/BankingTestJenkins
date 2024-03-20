pipeline{
    agent any
    stages{
        stage("checkout"){
            steps{
                git branch : 'main', url:'https://github.com/mridulkr18/BankingTestJenkins'
            }
        }
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
