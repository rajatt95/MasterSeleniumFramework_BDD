# MasterSeleniumFramework_BDD
With further updates - This project is designed and developed with the help of -
1. Udemy course (OmPrakash Chavan - Cucumber BDD Masterclass with Selenium WebDriver & Java) - 
[Learnings From Course.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998307/Learnings.From.Course.pdf)
![image](https://user-images.githubusercontent.com/26399692/152515639-83ff0b6e-3148-4c4c-821b-491c4d1f415e.png)
![image](https://user-images.githubusercontent.com/26399692/152515700-e7f086cf-4ed9-469c-b65c-51aeb841e783.png)
![image](https://user-images.githubusercontent.com/26399692/152515746-35b19cb5-9fcc-4304-9abd-1e9b872bf18f.png)

![image](https://user-images.githubusercontent.com/26399692/152515304-c933c4e0-f085-4b60-be3d-144caf9d9054.png)
![image](https://user-images.githubusercontent.com/26399692/152515549-abcc6a1e-4d54-4eba-b741-8b1910aee102.png)

<img width="717" alt="Screenshot by Snip My at 04-Feb-2022 at 2_41_05 AM" src="https://user-images.githubusercontent.com/26399692/152430606-3a88d967-4ebd-4976-a601-c75f2477d79d.png">

------------------------------------------------------------
**Framework features:**
1. Uses Domain objects
2. Support multiple Runners - TestNG, JUnit, CLI
3. Uses Dependency Injection Framework
4. Supports parallel execution
5. Uses API to setup the Application state
6. Captures screenshot on Scenario Failure
7. Supports command line execution using Maven
8. Supports CI/CD integration
------------------------------------------------------------
It has a concept of Atomic tests (Achieved by Selenium WebDriver API and RestAssured API)
------------------------------------------------------------
# Atomic Tests:
![image](https://user-images.githubusercontent.com/26399692/138962929-70094e77-ff3c-405e-95f8-c91c4e0912a6.png)
------------------------------------------------------------
Updations done:
------------------------------------------------------------
**Reports (me.jvt.cucumber -> reporting-plugin) ** 
![image](https://user-images.githubusercontent.com/26399692/152516617-160ec7de-c330-490e-9cb9-78b7d50cbe5d.png)
------------------------------------------------------------
**Screenshot on failure to Reports** 
![image](https://user-images.githubusercontent.com/26399692/152516718-701a6cc9-bf46-475f-824f-406413fa8288.png)
------------------------------------------------------------
**Zip reports**
------------------------------------------------------------
**Browser instances from pom.xml**
![image](https://user-images.githubusercontent.com/26399692/152516862-973ca6e9-bf4e-45de-85f5-f7fba24f4927.png)
------------------------------------------------------------
**Execution**
1. mvn clean test (This will execute with default env (Stg) and browser (Edge))
2. mvn clean test -Denv=INT -Dbrowser=firefox (his will execute with on Int and Firefox browser)
3. mvn clean test -Denv=INT -Dbrowser=firefox -Dcucumber.filter.tags@smoke (This will execute with on Int and Firefox browser and scenarios tagged as smoke)
------------------------------------------------------------

[Cucumber_Reports_Local.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998343/Cucumber_Reports_Local.pdf)
![image](https://user-images.githubusercontent.com/26399692/152431537-75cab046-67a6-4387-a980-f3dc19031f5c.png)
------------------------------------------------------------
[Cucumber_Reports_Cloud.pdf](https://github.com/rajatt95/MasterSeleniumFramework_BDD/files/7998338/Cucumber_Reports_Cloud.pdf)
![image](https://user-images.githubusercontent.com/26399692/152431482-e010a8c0-25b8-425f-be92-83d0f9a52fb2.png)

