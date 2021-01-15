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

            }

            steps {
                sh "echo ${env.projectName}"
                sh "echo ${projectName}"

                script {
                    def projectNames = "${projectName}".split(",")
                    for (int i = 0; i < projectNames.size(); ++i) {
                         def curProjectName = "${projectNames[i]}"
                         //echo "start deploy ${curProjectName}"
                         //def target = "${curProjectName}/target"
                         //def jar = "${curProjectName}/target/*.jar"
                         //sshPublisher(publishers: [sshPublisherDesc(configName: '192.168.0.122', transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/usr/local/jenkinstest', remoteDirectorySDF: false, removePrefix: "${target}", sourceFiles: "${jar}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

                         //制作镜像
                         if("${curProjectName}" == "order"){
                            def port = 9050
                         }else if("${curProjectName}" == "user"){
                            def port = 9060
                         }

                         sh '''docker build --build-arg PORT=${port} --build-arg TARGET_JAR=./${curProjectName}/target/${curProjectName}-2.1.8.RELEASE.jar -t order:1.0 .
                         docker images
                         '''
                         echo "deploy ${curProjectName} success"
                    }
                }
            }
        }



    }
}

