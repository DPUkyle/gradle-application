gradle-application
==================

A dummy app to illustrate a standalone Java application which bundles Gradle as a dependency.

Leverages the Gradle `application` plugin to create a self-contained zip or tar deliverable.

## Usage

### Generate a zip
`$ ./gradlew distZip` _creates self-contained zip file in `build/distributions/gradle-application.zip`_ 

### Generate a tar
`$ ./gradlew distTar` _creates self-contained tarball in `build/distributions/gradle-application.tar`_

### Locally deploy the exploded archive
`$ ./gradlew installDist` _app is unzipped to `build/install/gradle-application`_

### Execute the locally-deployed exploded archive
 * `$ build/install/gradle-application/bin/gradle-application`
 * `$ build/install/gradle-application/bin/gradle-application --help`
 * `$ build/install/gradle-application/bin/gradle-application --dependency junit:junit:4.12`
 
### Run the app without installing
`$ ./gradlew run`

### Debug the app
`$ ./gradlew run --debug-jvm`, then create Remote configuration in IntellJ and attach to localhost:5005