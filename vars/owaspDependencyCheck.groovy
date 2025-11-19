def call(String servicePath) {

    echo "Running Dependency Check for: ${servicePath}"

    dependencyCheck additionalArguments: "--scan ${servicePath}", 
                    odcInstallation: 'OWASP',
                    failBuildOnCVSS: 7

    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
