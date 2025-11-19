def call(String ImageName, String ImageTag){
    withCredentials([usernamePassword(credentialsId: 'docker-login-cred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker login -u ${USER} -p ${PASS}"
        sh "docker push ${ImageName}:${ImageTag}"
    }
}
