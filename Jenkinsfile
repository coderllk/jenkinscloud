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
                    steps {
                        sh "echo ${env.projectName}"
                        for (item in "${env.projectName}".tokenize(',')){
                        	echo "Deploying to " + item
                        }
                    }
                }



    }
}

