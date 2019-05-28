#!/usr/bin/env bash

yum -y install wget

useradd sqoop
echo "sqoop" | passwd sqoop --stdin &>/dev/null
sudo su
echo "sqoop  ALL=(ALL) ALL" >> /etc/sudoers

su - sqoop

cd /home/sqoop
wget https://mirrors.tuna.tsinghua.edu.cn/apache/sqoop/1.99.7/sqoop-1.99.7-bin-hadoop200.tar.gz

tar -xzvf sqoop-1.99.7-bin-hadoop200.tar.gz
mv sqoop-1.99.7-bin-hadoop200 sqoop2
