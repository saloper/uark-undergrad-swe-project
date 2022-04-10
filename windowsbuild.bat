javac src/*.java -d bin/
cd bin
java -cp .;..\lib\postgresql-42.3.3.jar App
cd ..
