exec{'rsa_request1':
  path => "/usr/bin:/usr/sbin:/bin",
  command => "ssh-keygen -t rsa -P '' -f ~/.ssh/id_rsa",
  user => "hadoop",
}

exec { 'rsa_request2':
  path   => "/usr/bin:/usr/sbin:/bin",
  command => "cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys",
  user => "hadoop",
}

