****************************
**** Build specification ****
****************************

1) Build tool 
* maven3
* main pom:
<groupId>tch.code</groupId>
<artifactId>client-catalog</artifactId>
<version>0.1-SNAPSHOT</version>
<packaging>pom</packaging>
* profiles: no profiles definied

2) Used frameworks (version as specified inside project pom files):
* spring 3
* hibernate 3
* @TO BE COMPLETED

3)Runtime:
* Java:
- JSE 6 compatible
* application server: 
- Jetty 
* database: 
- configured for derby [for another one application must be rebuilded after changes in context for data source configuration]
- database schema included in project configuration
* web browser: 
- any that supports JavaScript
* all depedencies included in web module [WEB-INF/lib]

4) Other info:
* no automatic deployment	
* not published in control version system