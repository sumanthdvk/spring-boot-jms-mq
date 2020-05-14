# spring-boot-jms-mq
Sample mq jms app using spring boot starter

## Run IBM MQ container in local

`docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443:9443 -d ibmcom/mq`
