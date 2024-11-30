# TendableProject
Assignment for Tendable Tech Challenge by Gaurav Jain (gauravjain.testing@gmail.com)

main Folder under which code is organized
TendableProject

When code is downloaded as .zip file from GitHub, unzip and rename "TendableProject-main" to "TendableProject". Copy folder to C:\ or D:\

## Software & Tools
1. IntelliJ Community Edition 2024.2.1
2. Chrome v131.0.6778.86
3. Edge v131.0.2903.70

## Strategy
1. I have used Singleton pattern for WebDriver initialization. PageFactory is used for organizing Page objects in Selenium using Java.
2. CSS selectors are used for Page Objects
3. No hard coded values are used in code. Environment related values like Browser, Base URL, page URL's are organized in properties file. Similarly data for entering values in Contact page are also organized in properties file
4. Top Menu objects are organized in HomePage Page Objects class even though we click on all Top Menu options. This is done to reduce duplication of same objects across Page Objects classes for each Top Menu page. 
4. Code can run for either Chrome (131.0.6778.86) or Edge(131.0.2903.70). Refer How to Run section
5. Maven (for Build) and TestNG (for Tests) have been used
6. Code has been documented with suitable comments wherever necessary
7. Results of execution on Chrome and Edge are present in Results folder

## Configuration & Structure
1. package org.tendable.seleniumproject.common has the below classes
   a. CommonElementMethods: Class with generic methods for interacting with WebElements
   b. CommonMethods: Class has methods to interact with .properties files
2. package org.tendable.seleniumproject.pageobjects has the below classes
   a. ContactPage: Page Objects class for Contacts Page Objects (Contact Form) and filling the Contacts Form
   b. HomePage: Page Objects class for Top Menu Objects.
3. package org.tendable.seleniumproject.webdriver
   a. SeleniumWebDriver: Class uses Singleton Pattern to return the WebDriver object. Webdriver for Chrome/Edge is initialized depending on the "browser" specified in the env.properties file
4. /src/main/resources/env.properties: Properties file with environment specific values
5. /src/test/resources/data.properties: Properties file with data for the Contact Form
6. package test has the below classes
   a. AboutTest: Test Class for the About Page
   b. ContactTest: Test Class for Contact Page. Verify Form fields are displayed, Fill Form Details and verify Error Message
   c. ContentHubTest: Test Class for the Content Hub Page
   d. HomeTest: Test Class for Home Page of Tendable with Top-Menu verification
   e. ProductsTest: Test Class for the Products Page
   f. SectorsTest: Test Class for the Sectors Page

## How to Run
1. Ensure Webdriver version matches the browser present on machine.
2. For running on Chrome Browser. keep "browser = chrome" in env.properties. Run TestNG Project to execute tests on Chrome Browser
3. For running on Edge Browser. keep "browser = edge" in env.properties. Run TestNG Project to execute tests on Edge Browser
