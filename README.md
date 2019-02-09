[![Build Status](https://travis-ci.org/Fraser-Chapman/Hackathon.svg?branch=master)](https://travis-ci.org/Fraser-Chapman/Hackathon)

# Hackathon
Repository for the Manchester Digital government open data hackathon.

# How to use

## Front end
The front end client is located inside of the "MapApp" folder in the project. The client
uses the Angular framework and so can be ran by using the Angular cli command
`ng serve --open`.

## Java Rest API
The back end api is written in Java and uses the Springboot framework and can be launched
via intellij or by navigating to the project root directory in the command line and using
the command `./gradlew bootRun` or `gradlew bootRun` on windows.

## Python Rest Service
Please ensure you are using a python 3.7 interpreter.

The python back end service requires a lot more set up to run. It requires a python virtual
environment with the following modules installed: pip, flask, OSGridconverter.

Once this has been set up you should be able to launch the service by navigating to the
"pythonservice" directory and using the command `python server.py` or by launching it through
the python IDLE interpreter.