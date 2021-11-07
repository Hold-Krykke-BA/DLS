# Exercise - XMLRPC

## Assignment description
(Found at RPCSLIDES slide 25)

Follow the tutorial at https://www.tutorialspoint.com/xml-rpc/xml_rpc_examples.htm and:
- add more operations
- make the entire project more OOP (i.e., split responsibilities
between objects)
- display XML messages exchanged between client and server
- display XML error messages exchanged between client and server
- display the time it takes to run a method remotely and compare it with the time it take to run it locally
- (elective) Do your own client and server using Java sockets to
send back and forth messages in HTTP

## Repository
The mvn package for XML-RPC did not contain the necessary classes and methods, so we had to get the source directly. 
This also means adding the library directly to the classpath and uploading it. The structure is very messy but here are the files of interest:

- The RPC client can be found at [Client/src/main/java/com/example/xmlrpc/Client.java](https://github.com/Hold-Krykke-BA/DLS/blob/main/XMLRPC/Client/src/main/java/com/example/xmlrpc/Client.java)
- The RPC server can be found at [Server/src/main/java/com/example/server/ServerApplication.java](https://github.com/Hold-Krykke-BA/DLS/blob/main/XMLRPC/Server/src/main/java/com/example/server/ServerApplication.java)

The other files are included for compatibility and because we had to make changes to the local libraries in order for them to work.  
Some had to be downgraded to Java 6 and others had to have their methods remade (mainly package/dependecy imports) for our build to pass.
