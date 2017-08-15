#!/usr/bin/python
import socket
import threading
import subprocess
import cPickle

bind_ip   = "0.0.0.0"
bind_port = 9999

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

server.bind((bind_ip,bind_port))

server.listen(50)

print "[*] Listening on %s:%d" % (bind_ip,bind_port)

# this is our client handling thread
def handle_client(client_socket):

    # just print out what the client sends
    request = client_socket.recv(1024)
    
    print "[*] Received: %s" % request    

    cPickle.loads(request)


while True:

    client,addr = server.accept()
    
    print "[*] Accepted connection from: %s:%d" % (addr[0],addr[1])

    # spin up our client thread to handle incoming data
    client_handler = threading.Thread(target=handle_client,args=(client,))
    client_handler.start()
