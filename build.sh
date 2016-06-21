mvn clean package

sudo rm -rf /var/lib/tomcat8/webapps/smt
sudo rm -rf /var/lib/tomcat8/webapps/smt.war

sudo cp target/smt.war /var/lib/tomcat8/webapps/

