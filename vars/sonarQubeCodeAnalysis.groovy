def call(String language, String projectName, String projectKey, String sonarUrl, String sonarToken) {

    withSonarQubeEnv("MySonarServer") {

        // ---------- MAVEN (Java / Spring Boot) ----------
        if (language == "maven") {
            sh """
                mvn sonar:sonar \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.host.url=${sonarUrl} \
                -Dsonar.login=${sonarToken}
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
                -Dsonar.login=${sonarToken}
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
                -Dsonar.login=${sonarToken}
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
                -Dsonar.login=${sonarToken}
            """
        }

        // ---------- GRADLE (Kotlin, Java) ----------
        else if (language == "gradle") {
            sh """
                gradle sonarqube \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.projectName=${projectName} \
                -Dsonar.host.url=${sonarUrl} \
                -Dsonar.login=${sonarToken}
            """
        }

        // ---------- DOTNET ----------
        else if (language == "dotnet") {
            sh """
                SonarScanner.MSBuild.exe begin \
                /k:${projectKey} \
                /n:${projectName} \
                /d:sonar.host.url=${sonarUrl} \
                /d:sonar.login=${sonarToken}

                msbuild

                SonarScanner.MSBuild.exe end \
                /d:sonar.login=${sonarToken}
            """
        }

        // ---------- Unsupported ----------
        else {
            error "Unsupported language type: ${language}"
        }
    }
}
