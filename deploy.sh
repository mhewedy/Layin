SRC_DIR=WEB-INF/src
CLASSES_DIR=WEB-INF/classes

#cleaning
rm -rf $CLASSES_DIR/*

#build
javac -d $CLASSES_DIR -cp .:$CATALINA_HOME/lib/servlet-api.jar $SRC_DIR/*.java

#deploy
jar cvf Layin.war *
