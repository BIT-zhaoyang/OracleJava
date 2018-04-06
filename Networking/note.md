# URL class
URL class in Java is a high-level class for connecting to a website. Since most
website uses HTTP, the URL class in Java is HTTP centric.

#Sockets
A socket is one endpoint of a two-way communication link between two programs
running on the network.

How does socket for TCP work? 
According to RFC 793, 
```
socket
          An address which specifically includes a port identifier, that
          is, the concatenation of an Internet Address with a TCP port.

connection
          A logical communication path identified by a pair of sockets.
```
However, in OS, people implement Socket class to represent both socket and connection.
Also, socket is a file descriptor used by OS to operate on files.

Ref:
https://softwareengineering.stackexchange.com/questions/308625/tcp-three-way-handshake-which-port
https://stackoverflow.com/questions/11129212/tcp-can-two-different-sockets-share-a-port

Java provides Socket and ServerSocket classes for low level network operations.
