# CSCE3513 Project
## Build instructions (for windows)
```
git clone https://github.com/saloper/CSCE3513-Project.git
cd CSCE3513-Project
windowsbuild.bat
```
or manually
```
git clone https://github.com/saloper/CSCE3513-Project.git
cd CSCE3513-Project
javac src/*.java -d bin/
cd bin
java -cp .;..\lib\postgresql-42.3.3.jar App
```

## Build instructions (for linux)
```
git clone https://github.com/saloper/CSCE3513-Project.git
cd CSCE3513-Project
./linuxbuild.bash
```
or manually
```
git clone https://github.com/saloper/CSCE3513-Project.git
cd CSCE3513-Project
javac src/*.java -d bin/
cd bin
java -cp "../lib/postgresql-42.3.3.jar:." App
```


## Members
- Justin Austin
- Spencer Loper
- Cameron Wilson
- Alec Anderson
- Carson Jefferies
