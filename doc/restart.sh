#!/bin/bash
PROJECT_PATH=/home/zfqs/
PROJECT_NAME=payment-clean-0.0.1-SNAPSHOT.jar
PROJECT_ALL_LOG_NAME=log/runLog.log
# stop process
tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Stop Process...'
    kill -15 $tpid
fi
sleep 5

tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'Kill Process!'
    kill -9 $tpid
else
    echo 'Stop Success!'
fi

# start process
tpid=`ps -ef|grep $PROJECT_NAME|grep -v grep|grep -v kill|awk '{print $2}'`
if [ ${tpid} ]; then
    echo 'App is already running.'
else
    echo 'App is NOT running.'
    nohup java -jar $PROJECT_PATH$PROJECT_NAME >/dev/null 2>&1 &
    echo Start Success!
    sleep 3
    tail -f $PROJECT_PATH$PROJECT_ALL_LOG_NAME
fi
