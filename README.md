# goldbar-puzzle-automation

**Quick start:**

This project has been automated in 
Serenity BDD Framework to find the fake gold bar using a 
weighing scale in minimum number of attempts.
Application link: _http://ec2-54-208-152-154.compute-1.amazonaws.com/_

**Requirements:**

1. Java 8/11
2. Latest maven version.
3. Latest chrome browser

**Steps to run the test:**

1. Download the project 
2. Open the Command prompt/Terminal and navigate to project root folder
3. Enter 'mvn verify' to run the test in default chrome browser
   For chrome headless: verify -Dwebdriver.driver=chrome -Dheadless.mode=true
   Firefox: verify -Dwebdriver.driver=firefox
   
The project will execute and will display the test report path at the end of the execution under SERENITY REPORTS heading.
Report location: `_Project-root-folder/target/site/serenity/index.html_`

**Verification:** 

Open Index.html in any browser to view the test report and validate 
1. Fake gold bar number
2. Number of weighs
3. List of weighings
4. Success message upon finding correct fake bar.

**Pre-requisite setup:**

_Installing Java 8_

Go to http://www.oracle.com/technetwork/java/javase/downloads/index.html
Click on Download link for the JDK for Java 8
Click on accept license for the development kit
Click on the download link for the OS you are running
Click on save file
When the file finishes downloading, run the file and follow the
on-screen instructions to install Java

_Installing Maven_

Mac OS:

Install Homebrew
Open Terminal
Type in: ruby -e "$(curl -fsSL
https://raw.githubusercontent.com/Homebrew/install/master/install)"
You will need to enter in your password when prompted
Type in: brew install maven
To verify the installation was successful, type in: mvn -version

Windows OS:

Download the "Binary zip archive" file from
https://maven.apache.org/download.cgi
Follow the instructions located at https://maven.apache.org/install.html