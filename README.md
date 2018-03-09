### gif crawler!

To build the package: 

    mvn clean package

To run the application: 
    
    java -jar target/crawler-1.0-SNAPSHOT.jar 

Hint: if you want to run this on your own db, 
plz write your own application-pro.yml and add option:
    
    –Dspring.profiles.active=pro

To test the application(default working in pro env):

    mvn -Dtest=CommonTest test -Dmaven.test.skip=false
