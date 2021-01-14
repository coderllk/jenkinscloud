pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }


    stages {
        stage('Build') {
            steps {

                sh "pwd"
                sh "ls -ll"
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('deploy') {

        environment {
        	projectName =  "$params.projectName"
        	projectNames = projectName.split(",")

         }

                    steps {
                        sh "echo ${env.projectName}"
                        sh "echo ${projectName}"
                        script {
                            def browsers = ['chrome', 'firefox']
                            for (int i = 0; i < browsers.size(); ++i) {
                                 echo "Testing the ${browsers[i]} browser"
                            }
                        }
                    }
        }



    }
}

