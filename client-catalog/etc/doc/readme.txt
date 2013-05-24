*******************************
--- 1. Build specification ----
-------------------------------
*******************************
1) Build tool 
* maven3
* main pom:
<groupId>tch.code</groupId>
<artifactId>client-catalog</artifactId>
<version>0.1-SNAPSHOT</version>
<packaging>pom</packaging>
* profiles: no profiles definied
* running: go to main project and execute mvn clean install
* you get client-catalog.war in target folder for client-catalog-webapp

2) Used frameworks (version as specified inside project pom files):
* Spring 3
* Hibernate 3
* Freemarker

3)Runtime:
* Java:
- JSE 6 compatible
* application server: 
- Jetty 
* database: 
- configured for derby [for another one application must be rebuilded after changes in context for data source configuration]
- database schema included in project configuration [client-catalog/etc/sql]
* web browser: 
- any that supports JavaScript
* all depedencies included in web module [WEB-INF/lib]

4) Other info:
* no automatic deployment	
* SCM repository: git clone https://Tomasz.Chrul@code.google.com/p/client-catalog/ 


********************************
--- 2. Runtime specification ---
--------------------------------
********************************
I. Database
1. Run data base server (first path element is derby installation directory):
- execute: db-derby-10.9.1.0-bin\startNetworkServer.bat [or startNetworkServer script on UNIX/LINUX]
2. Connect to Derby console:
- run ij - execute: ij.bat
3. Connect to database in console:
- type and execute command: CONNECT 'jdbc:derby://localhost:1527/client-catalog;create=true';
4. Create schema tables" in ij (first path element is client-catalog project main module folder - copy etc folder to derby/bin location to run command below or type complete path in RUN command):
- type and execute command: RUN 'etc/sql/001_CREATE_TABLE.sql';

II. Web container
1. Run Jetty from installation folder (eg. jetty-distribution-9.0.3.v20130506) with default configuration:
- execute: java -jar start.jar
- REMINDER: it's possible that you need change default port for some reason

2. Deploy application:
- copy client-catalog.war file to webapps folder in Jetty installation folder

III. Browser:
1. Use localhost address.
2. Application main page URL:
* for example:  http://localhost:18080/client-catalog


********************************
--- 3. TODO LIST ---------------              
--------------------------------
********************************
1. View 
* prepare table with sort and filtering (FTL/HTML + CSS + Ajax/Javascript)
* activate form to add and edit (FTL/HTML + CSS + Ajax/Javascript)

2. Controller
* configure path for edition views
* configure navigation

3. DAO
* resolve problem with inserts
* do more sophisticated schema design