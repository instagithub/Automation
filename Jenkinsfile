import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy

@Library("ve-lib@test/apps/branchlib")
@Library("apps-lib@master") _

env.GIT_REPO_URL = "https://git.pega.io/scm/crm/crm-all.git"
env.ARTIFACTORY_URL = "https://internal.bin.pega.io/artifactory"
env.ARTIFACTORY_REPO = "https://internal.bin.pega.io/artifactory/repo2"
env.CLOUD_ARTIFACTORY_URL='https://cirrus.jfrog.io/cirrus'

def params = [:]
params["prResultLinks"] = """
Cucumber Results can be found @ ${this.env.BUILD_URL}Cucumber_Test_Results_-_BUILD/
Output can be found @ ${this.env.RUN_DISPLAY_URL} """
params["prExceptionLinks"] = "Test results can be found @ ${this.env.BUILD_URL}\n" +
"Output can be found @ ${this.env.RUN_DISPLAY_URL}"
params["bitbucketCredentials"] = 'bitbucket-prpc'
params['buildServerURL'] = 'http://10.60.214.175:9080/'

def options = "JAVA_OPTS='-Xmx1024M -XX:MaxPermSize=512M -XX:ReservedCodeCacheSize=512M'"

env.LATEST_PRPC_VERSION = ""

// TODO: remove this
def crmBuildServerUrl = "http://10.60.214.175:9080"
def stackId = "PegaCRM-" + env.BUILD_NUMBER + "-" + "PrepBranch"

node('CRM-image-jdk8') {
    try {
        timestamps {
            withPRFlow(params) {

                ansiColor('xterm') {
                    withCredentials([usernamePassword(credentialsId: 'artifactory2', passwordVariable: 'ARTIFACTORY_PASSWORD', usernameVariable: 'ARTIFACTORY_USER')]) {
                        withCredentials([usernamePassword(credentialsId: 'readonlycreds-artifactory', passwordVariable: 'READONLY_ARTIFACTORY_PASSWORD', usernameVariable: 'READONLY_ARTIFACTORY_USER')]) {
                            writeFile file: "/root/.gradle/gradle.properties",
                                    text: "artifactoryUser=${ARTIFACTORY_USER}\n" +
                                            "artifactoryPassword=${ARTIFACTORY_PASSWORD}\n" +
                                            "artifactoryURL=${ARTIFACTORY_URL}\n" +
                                            "readonlyArtifactoryUser=${READONLY_ARTIFACTORY_USER}\n" +
                                            "readonlyArtifactoryPassword=${READONLY_ARTIFACTORY_PASSWORD}\n" +
                                            "dockerRegistryUrl=https://docker-dev-local.bin.pega.io"
                        }
                    }

                    echo '------------------ Start of Code Checkout ------------------'

                    checkout scm

                    def props = readProperties file: 'gradle.properties'
                    def CRM_BUILD_BASE_VERSION = props['CRM_BUILD_BASE_VERSION']
                    def CRM_BUILD_GROUP_ID = props['CRM_BUILD_GROUP_ID']

                    env.CRM_BUILD_ARTIFACT_ID = props['CRM_BUILD_ARTIFACT_ID']

                    env.crmVersion = "${CRM_BUILD_BASE_VERSION}-${env.BUILD_NUMBER}"
                    //DSS value to update on build server
                    def crmDSSKey = "CPM!CRMVERSION"
                    def crmDSSValue = "${CRM_BUILD_BASE_VERSION}-${this.env.BUILD_NUMBER}"

                    //Query for fetching the PRPC build version
                    sh "chmod a+x gradlew && sleep 2 && ./gradlew clean lastValidatedBuild"
                    buildProps = readProperties file: "build/build.properties"
                    env.LATEST_PRPC_VERSION = buildProps['build.version']
                    echo "PRPC Version: ${env.LATEST_PRPC_VERSION}"

                    if (LATEST_PRPC_VERSION && LATEST_PRPC_VERSION.trim()) {
                        def desc = " PRPC Version: ${LATEST_PRPC_VERSION}"
                        currentBuild.description = currentBuild.description ? "${currentBuild.description} ${desc}" : "${desc}"
                    }

                    stage('Build CRM') {
                        node('Hyd_executor') {
                            checkout scm
                            withCredentials([usernamePassword(credentialsId: 'artifactory2', passwordVariable: 'ARTIFACTORY_PASSWORD', usernameVariable: 'ARTIFACTORY_USER')]) {

                                sh "chmod a+x gradlew && sleep 2 && ./gradlew updateDSS -PbuildServerURL=${crmBuildServerUrl} -PDSSKey=${crmDSSKey} -PDSSValue=${crmDSSValue}"
                                //Exports the CRM application from buildServer and uploads it to artifactory
                                // Always uploads to same location - apps-dev-local/com/pega/product/PegaCRM_74_07.40/ExportWizard/PegaCRM_75.zip
                                sh "chmod +x gradlew && ./gradlew clean exportApp -PbuildServerURL=${crmBuildServerUrl}"
                                //TODO: Uncomment this
                                //exports pegaunit RAP from builServer and pushes to
                                //sh "./gradlew exportPegaUnits -PbuildServerURL=${crmBuildServerUrl}"
                            }
                        }
                        //downloads the CRM RAP and publishes the individual components with proper version
                        sh "chmod +x gradlew && ./gradlew clean artifactoryPublish -PpublishBuild=true -PgroupId=${CRM_BUILD_GROUP_ID} -PartifactId=${env.CRM_BUILD_ARTIFACT_ID} -Pversion=${env.crmVersion} -Puploadrepokey=apps-dev-local"
                    }

                    stage('Publish Tarball') {
                        env.GRADLE_OPTS = "-Duser.timezone=America/New_York"
                        echo '--------------- Import RAPs and publish tarball -----------------'
                        def uniqueID = UUID.randomUUID().toString()
                        try {
                            env.JAVA_OPTS = "-Xmx1024M -XX:MaxPermSize=512M -XX:ReservedCodeCacheSize=512M"

                            //start database with determined prpcVersion
                            sh "chmod +x gradlew && ./gradlew startDatabase -PjobKey=${uniqueID} -PdbPort -PtarballVersion=${env.LATEST_PRPC_VERSION} -PrepositoryName=apps-dev-local --stacktrace"
                            //TODO correct this
                            def productRAPListToImport = "${CRM_BUILD_GROUP_ID}:PegaCRM:${env.crmVersion},${CRM_BUILD_GROUP_ID}:KMSampleData:${env.crmVersion},${CRM_BUILD_GROUP_ID}:PegaCRMSample_DDL:${env.crmVersion},${CRM_BUILD_GROUP_ID}:PegaCRMSample_DML:${env.crmVersion}"
                            //def productRAPListToImport = "${CRM_BUILD_GROUP_ID}:PegaCRM_74:${env.crmVersion},${CRM_BUILD_GROUP_ID}:PegaCRMSample_DDL:${env.crmVersion},${CRM_BUILD_GROUP_ID}:PegaCRMSample_DML:${env.crmVersion},${CRM_BUILD_GROUP_ID}:KMSampleData:${env.crmVersion},com.pega.product:PackageCRMPegaUnits_01.01:ExportWizard@zip"
                            //imports RAPs and publishes tarball with specified GAV coordinates
                            //TODO: change pega units to true
                            sh "export ${options} && ./gradlew artifactoryPublish -PpublishTarball=true -PimportPegaUnits=false -PjobKey=${uniqueID} -PappServerId=${uniqueID} -PproductRAPList=${productRAPListToImport} " +
                                    " -PtomcatImageTag=latest -PgroupId=com.pega.crm.docker -PartifactId=prpc-data-PegaCRM-postgres-9.4-ss-st -Pversion=${env.crmVersion} -Puploadrepokey=apps-dev-local"

                        } catch (Exception e) {
                            if (this.RAP_LIST) {
                                try {
                                    echo "app server logs"
                                    sh "docker logs ${uniqueID}-appServer"
                                } catch (Exception ex) {
                                    echo "exception in getting tomcat logs ${ex.toString()}. Ignoring"
                                }
                            }
                            throw e
                        } finally {
                            sh "chmod +x gradlew && ./gradlew teardownDatabase teardownAppServer -PjobKey=${uniqueID} -PappServerId=${uniqueID} -PdbPort --continue --stacktrace"
                        }
                    }

                    echo '--------------- Launch PRPC and load PegaCRM -----------------'
                    withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'sut-deployer', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                        def sutProps = prepareSUT {
                            credentialsId = 'sut-deployer'
                            stackName = stackId
                            launchELB = false
                            //branches are imported before hand, we should ignore here
                            branchRAPList = ''

                            tarballRepo = 'apps-dev-local'
                            tarballGroupId = 'com.pega.crm.docker'
                            tarballArtifactId = 'prpc-data-PegaCRM-postgres-9.4-ss-st'
                            tarballVersion = "${this.env.crmVersion}"
                        }

                        stage('Smoke Validation') {
                            echo '------------- Run cucumber tests:Smoke Validation----------------'
                            validate {
                                type = "LUS"
                                profile = "ReadyToShare.groovy"
                                profilesDir = this.pwd() + "/pipeline/profiles"
                                sutURL = sutProps['sutURL']
                                dbStackName = "${stackId}-db"
                                appStackName = "${stackId}-app"
                                pipelineImageName = "CRM-image"
                                cucumberProjectName = "cucumber-webdriver"
                                cucumberReportTitle = "Cucumber Test Results - PR"
                                cucumberImage = 'ui-image-cucumber-aws'
                                artifactoryCredentials = 'artifactory2'
                            }
                        }
                    }
                    echo "Build Status: " + currentBuild.result
                    if (currentBuild.result != 'UNSTABLE' && currentBuild.result != 'FAILURE') {
                        echo '---------- Promoting build-----------'
                        stage('Promote Build') {
                            sh "chmod a+x gradlew && sleep 2 && ./gradlew --no-daemon copyArtifact -Pversion=${env.crmVersion}"

                            sh "./gradlew -s -Pversion=${CRM_BUILD_BASE_VERSION} -Prepo=apps-dev-local -PpruneMaxDaysToKeep=10 -PpathPrefix=com/pega/crm/docker/prpc-data-PegaCRM-postgres-9.4-ss-st deleteArtifact"

                            //Prune validated CRM repo artifacts
                            sh "./gradlew -s -Pversion=${CRM_BUILD_BASE_VERSION} -Prepo=apps-release-local -PpruneMaxDaysToKeep=15 -PpathPrefix=com/pega/crm/docker/prpc-data-PegaCRM-postgres-9.4-ss-st deleteArtifact"
                        }
                        stage('Publish SCE') {
                            def sceBranch = 'release/PegaCRM_81'
                            node ('3xlarge') {
                                git branch: sceBranch, changelog: true, credentialsId: 'Bitbucket', poll: false, url: 'https://meshgit.pega.com/stash/scm/cloud/strategic-app-pega-customerservice.git'
                                dir ('strategic-app-properties') {
                                    git credentialsId: 'Bitbucket', url: 'https://meshgit.pega.com/stash/scm/cloud/strategic-app-properties.git'
                                }
                                withCredentials([usernamePassword(credentialsId: 'artifactory', passwordVariable: 'ARTIFACTORY_PASSWORD', usernameVariable: 'ARTIFACTORY_USER')]) {
                                    sh "chmod a+x gradlew && ./gradlew clean artifactoryPublish --stacktrace --info --refresh-dependencies -PartifactoryURL=${CLOUD_ARTIFACTORY_URL} -PartifactoryUser=${ARTIFACTORY_USER} -PartifactoryPassword=${ARTIFACTORY_PASSWORD} -DBUILD_NUMBER=${this.env.BUILD_NUMBER} -DBRANCH_NAME=${sceBranch} -DBUILD_NAME=crm-ci-build -DBUILD_URL=${this.env.BUILD_URL} -PappBuildVersion=${this.env.crmVersion}"
                                }
                            }

                            // Prune SCE
                            withCredentials([usernamePassword(credentialsId: 'artifactory', passwordVariable: 'PRUNE_ARTIFACTORY_PASSWORD', usernameVariable: 'PRUNE_ARTIFACTORY_USER')]) {
                                sh "./gradlew -s -Pversion=${CRM_BUILD_BASE_VERSION} -Prepo=apps-dev-local -PplanName=crm-all -PpruneMaxDaysToKeep=15 -PpathPrefix=com/pega/servicecatalog/strategic-app-pega-crm -PappName=crm-ci-build -PbuildVersionProperty=build.number -PbuildNumberProperty=jenkins.build.number -PpruneArtifactoryURL=${env.CLOUD_ARTIFACTORY_URL} -PpruneArtifactoryUser=${PRUNE_ARTIFACTORY_USER} -PpruneArtifactoryPassword='${PRUNE_ARTIFACTORY_PASSWORD}' deleteArtifact"
                            }

                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        currentBuild.result = "FAILURE"
        throw e
    }finally {
        withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'sut-deployer', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
            sh "chmod a+x gradlew && sleep 2 && ./gradlew --no-daemon  down -PstackName=${stackId}-db,${stackId}-app,${stackId}-elb --stacktrace"
        }
        def subStatus = currentBuild.result ? currentBuild.result : "SUCCESS"
        def mailTemplate = readFile(encoding: 'UTF-8', file: "pipeline/templates/BuildMailTemplate")
        mailNotifier {
            template = "${mailTemplate}"
            subject = "[Pipeline] CRM Daily Builds #${this.env.BUILD_NUMBER} PRPC Build #${this.env.LATEST_PRPC_VERSION} - ${subStatus}!"
            recipient = this.env.CRM_CI_BUILD_MAIL_GROUP
            trigger = "AlwaysTrigger"
        }
    }
}
