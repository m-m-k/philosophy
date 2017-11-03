From openjdk:8-jdk

Expose 8080

Run mkdir /usr/src/app

Copy . /usr/src/app

Workdir /usr/src/app

Run ./gradlew build

Cmd java -jar ./build/libs/mmk-philosophy-0.1.0.jar
