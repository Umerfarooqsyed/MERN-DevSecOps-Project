def call(){
  dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP', failBuildOnCVSS: 7
  dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
