def call(String path=".", String reportPath="trivy-fs-report.json", String severity="CRITICAL,HIGH") {
    echo "Starting Trivy File System scan..."
    echo "Scan Path: ${path}"
    echo "Report File: ${reportPath}"
    echo "Pipeline will fail if Severity is ${severity}"

    // Run Trivy FS scan
    sh """
        trivy fs ${path} \
        --exit-code 1 \
        --severity ${severity} \
        -o ${reportPath} \
        --format json
    """

    echo "Trivy FS scan completed. Report saved at: ${reportPath}"
}
