#!/usr/bin/env bash

yum install -y wget
wget https://yum.puppetlabs.com/puppetlabs-release-el-7.noarch.rpm
rpm -ivh puppetlabs-release-el-7.noarch.rpm
yum -y install puppet-server