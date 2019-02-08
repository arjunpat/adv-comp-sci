find . -type f -name "*.class" -delete
javac *.java -Xlint:unchecked
java Runner