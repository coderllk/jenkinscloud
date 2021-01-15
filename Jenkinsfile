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
                         echo "start deploy ${curProjectName}"
                         def target = "${curProjectName}/target"
                         def jar = "${curProjectName}/target/*.jar"

                         //制作镜像
                         if("${curProjectName}" == "order"){
                             def port = 9050
                             sshPublisher(publishers: [sshPublisherDesc(configName: '192.168.0.122', transfers: [sshTransfer(cleanRemote: false, excludes: '',
                             execCommand:
                             '''docker build --build-arg PORT=9050 --build-arg TARGET_JAR=order-2.1.8.RELEASE.jar -t order:1.0 .''',
                              execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/usr/local/jenkinstest', remoteDirectorySDF: false, removePrefix: "${target}", sourceFiles: "${jar}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

                         }else if("${curProjectName}" == "user"){
                             def port = 9060
                             sshPublisher(publishers: [sshPublisherDesc(configName: '192.168.0.122', transfers: [sshTransfer(cleanRemote: false, excludes: '',
                             execCommand:
                             '''docker build --build-arg PORT=9060 --build-arg TARGET_JAR=user-2.1.8.RELEASE.jar -t user:1.0 .''',
                             execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '/usr/local/jenkinstest', remoteDirectorySDF: false, removePrefix: "${target}", sourceFiles: "${jar}")], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])

                         }
                         def dockerBuild = "docker build "+"--build-arg "+"PORT=${port}"+
                            " --build-arg"+" TARGET_JAR="+"${curProjectName}"+"-2.1.8.RELEASE.jar -t "+"${curProjectName}"+":1.0 .""
                         sh "echo ${dockerBuild}"

                         echo "deploy ${curProjectName} success"
                    }
                }
            }
        }



    }
}

