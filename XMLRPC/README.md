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
The mvn package for XML-RPC did not contain the necessary classes and methods, so we had to get the source directly, included in [apache-xmlrpc-3.1.2-src](apache-xmlrpc-3.1.2-src). ([external link source](https://archive.apache.org/dist/ws/xmlrpc/sources/apache-xmlrpc-3.1.2-src.zip))  
This also means adding the library directly to the classpath, which makes the repository very messy.  

The library is included here locally, and has to be added through the IDE to the classpath (as a library/module). You then have to fix errors in the libraries, such as missing dependencies or wrong import pointers. Some classes were also built in a Java 6 environment, so they do not fit the requirements of modern java - an example is how all methods should be implemented for the implementation of an abstract class.

- The RPC client can be found at [Client/src/main/java/com/example/xmlrpc/Client.java](https://github.com/Hold-Krykke-BA/DLS/blob/main/XMLRPC/Client/src/main/java/com/example/xmlrpc/Client.java)
- The RPC server can be found at [Server/src/main/java/com/example/server/ServerApplication.java](https://github.com/Hold-Krykke-BA/DLS/blob/main/XMLRPC/Server/src/main/java/com/example/server/ServerApplication.java)

The other files are included for compatibility and because we had to make changes to the local libraries in order for them to work.  
Some had to be downgraded to Java 6 and others had to have their methods remade (mainly package/dependecy imports) for our build to pass.

## Results
An example of the process is the following preconditions:
```java
int element1 = 200; //added to "params"
int element2 = 50; //added to "params"
Object result = client.execute("sample.sum", params);
```

It is worth noting that the "sample.sum" parameter (which matches the receiving classes' method name) does not do anything in this implementation - but is required for implementation.

Which connects to the server and returns the following response:

```
The sum is: 250
```

![image](https://user-images.githubusercontent.com/37186286/140659336-a00a7de6-bcab-46c2-819f-55eac9b97524.png)
