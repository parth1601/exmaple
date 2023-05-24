# Data Collector

## Description 
Collect data till 1MB then write to file.

## Environment Variables

| Variable Name | Default Value                                  | Note  |
|---------------|------------------------------------------------|-------|
| CRON_DURATION | 10m                                            |       | 
| BUFFER_SIZE   | 1                                              | in MB |
| FILE_PATH     | ./src/main/java/org/example/output/output.json |       |

## Requirements

- Java version 17+
- Maven (latest)

## Step to run

- Clone repository :
  ```shell
  git clone https://github.com/parth1601/exmaple.git
  ```
- Navigate to root directory :
  ```shell
  cd example
  ```
- Clean, Compile and Build jar file :
  ```shell
  mvn clean package
  ```
- Run jar file :
  ```shell
  java -jar .\target\quarkus-app\quarkus-run.jar
  ```