#!/usr/bin/env bash

cd /opt
wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accepsecurebackup-cookie" https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.tar.gz > /dev/null
tar -xzvf jdk* > /dev/null
mv jdk1.8.0_201 jdk8
echo "export JAVA_HOME=/opt/jdk8" >> /etc/profile
echo "export CLASSPATH=\$JAVA_HOME/lib" >> /etc/profile
echo "export PATH=\$PATH:\$JAVA_HOME/bin" >> /etc/profile
source /etc/profile

useradd hadoop
echo "hadoop" | passwd hadoop --stdin &>/dev/null
sudo su
echo "hadoop  ALL=(ALL) ALL" >> /etc/sudoers

su - hadoop
cd /home/hadoop
wget http://mirrors.shu.edu.cn/apache/hadoop/common/hadoop-2.8.5/hadoop-2.8.5.tar.gz > /dev/null
tar -xzvf hadoop-2.8.5.tar.gz > /dev/null
mv hadoop-2.8.5 hadoop2
sed -i '/<\/configuration>/i\\t<property>\n\t\t<name>fs.defaultFS<\/name>\n\t\t<value>hdfs://localhost:9000<\/value>\n\t<\/property>' /home/hadoop/hadoop2/etc/hadoop/core-site.xml
sed -i '/<\/configuration>/i\\t<property>\n\t\t<name>dfs.replication<\/name>\n\t\t<value>1<\/value>\n\t<\/property>' /home/hadoop/hadoop2/etc/hadoop/hdfs-site.xml
sed -i '/export JAVA_HOME=/i\export JAVA_HOME=/opt/jdk8' /home/hadoop/hadoop2/etc/hadoop/hadoop-env.sh
cd hadoop2
sudo bin/hdfs namenode -format
sudo sbin/start-dfs.sh


