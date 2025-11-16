def call(String Project, String ImageTag, String credsId){
    withCredentials([usernamePassword(credentialsId: credsId, usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker login -u ${USER} -p ${PASS}"
        sh "docker push ${USER}/${Project}:${ImageTag}"
    }
}
