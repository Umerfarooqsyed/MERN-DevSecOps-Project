def call(String language, String projectName, String projectKey, String sonarUrl) {

    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {

        withSonarQubeEnv("MySonarServer") {

            // ---------- MAVEN (Java / Spring Boot) ----------
            if (language == "maven") {
                sh """
                    mvn sonar:sonar \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=$SONAR_TOKEN
                """
            }

            // ---------- NODE.JS / MERN STACK ----------
            else if (language == "nodejs") {
                sh """
                    sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=$SONAR_TOKEN
                """
            }

            // ---------- PYTHON ----------
            else if (language == "python") {
                sh """
                    sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=$SONAR_TOKEN
                """
            }

            // ---------- GO / GOLANG ----------
            else if (language == "go") {
                sh """
                    sonar-scanner \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.sources=. \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=$SONAR_TOKEN
                """
            }

            // ---------- GRADLE (Kotlin, Java) ----------
            else if (language == "gradle") {
                sh """
                    gradle sonarqube \
                    -Dsonar.projectKey=${projectKey} \
                    -Dsonar.projectName=${projectName} \
                    -Dsonar.host.url=${sonarUrl} \
                    -Dsonar.login=$SONAR_TOKEN
                """
            }

            // ---------- DOTNET ----------
            else if (language == "dotnet") {
                sh """
                    SonarScanner.MSBuild.exe begin \
                    /k:${projectKey} \
                    /n:${projectName} \
                    /d:sonar.host.url=${sonarUrl} \
                    /d:sonar.login=$SONAR_TOKEN

                    msbuild

                    SonarScanner.MSBuild.exe end \
                    /d:sonar.login=$SONAR_TOKEN
                """
            }

            // ---------- Unsupported ----------
            else {
                error "Unsupported language type: ${language}"
            }
        }
    }
}
