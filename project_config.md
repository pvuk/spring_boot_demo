## Project Frameworks and APIs
* This Project is using Java8 + Spring boot + Maven + Git + MongoDB

## Download Project into local repository using git
* This Project depends on lib project which is available at [GitHub - Lib](https://github.com/pvuk/lib.git)

## Lombok jar mapping with eclipse.exe##
Installation Type 1:
1. lombok jars will be downloaded into .m2 folder in local Users folder.
    - Goto location -> `C:\Users\udaykiran\.m2\repository\org\projectlombok\lombok\1.18.2`.
    - Double click on lombok-1.18.2.jar., A new window will open.
    - Click on Specify location button -> Select where eclipse.exe file exist for ex: `I:\IDE\eclipse-jee-2018-09-win32-x86_64\eclipse`.
    - Click on Install / Update button.
    - Click on Quit Installer.

Installation Type 2:
1. Goto lombok latest version downloaded folder in .m2
     - Open cmd(Win+R) -> Paste below path(Shift + Insert)
     - `cd C:\Users\Priyanka\.m2\repository\org\projectlombok\lombok\1.18.2`
     - execute below command
     - `java -jar lombok-1.18.2.jar`
     </br>OR
     - `C:\Users\Priyanka\.m2\repository\org\projectlombok\lombok\1.18.2>java -jar lombok-1.18.2.jar`

2. open *eclipe.ini* file add below code
     - `-javaagent:D:\Softwares\eclipse-jee-2019-09-R-win32-x86_64\lombok.jar`
     - Makesure lombok.jar should exist in above path 
     </br> OR
     - change above path to below path with default jars windows loation .m2 install location `-javaagent:C:/Users/Priyanka/.m2/repository/org/projectlombok/lombok/1.18.2/lombok-1.18.2.jar`


## Syntax for writing markdown(.md) files
* [Basic writing and formatting syntax](https://help.github.com/en/articles/basic-writing-and-formatting-syntax#lists)
* [GitHub - Mastering-Markdown](https://guides.github.com/features/mastering-markdown/)
* [Atlassian - Markdown syntax guide](https://confluence.atlassian.com/bitbucketserver/markdown-syntax-guide-776639995.html)
 