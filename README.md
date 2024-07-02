Tasks
=================

Test authentication of Bynder portal.
-------------
Test API of https://www.themoviedb.org/
-------------
Create a load tests based on API test
-------------

Prerequisites
-------------

- bin directory of the Maven should be added to the PATH environment variable
- Tests is parametrized by csv files from test/java/resource folder

Clone the repo:
-------------
git clone -b master 


Run UI test
-------------
UI tests run: 
- pull docker image docker pull selenium/standalone-chrome
- start the image docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome
- run mvn clean test -Dtest=PositiveScenarioTests

Run API test
-------------
create docker image docker build -t bynder .
run the tests on docker image

Run performance tests
-------------
mvn clean test -Dtest=PerformanceTest






