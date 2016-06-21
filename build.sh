mvn clean package

sudo rm -rf /var/lib/tomcat7/webapps/smt
sudo rm -rf /var/lib/tomcat7/webapps/smt.war

sudo cp target/smt.war /var/lib/tomcat7/webapps/
