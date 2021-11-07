package com.example.server;

import org.apache.xmlrpc.server.XmlRpcHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcNoSuchHandlerException;
import org.apache.xmlrpc.webserver.WebServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.xmlrpc.*;

@SpringBootApplication
public class ServerApplication {

    public Integer sum(int x, int y) {
        return (x + y);
    }

    public static void main(String[] args) {

        SpringApplication.run(ServerApplication.class, args);
        try {

            System.out.println("Attempting to start XML-RPC Server...");

            WebServer server = new WebServer(80);

            server.getXmlRpcServer().setHandlerMapping(new XmlRpcHandlerMapping() {
                ServerApplication serverApp = new ServerApplication();

                @Override
                public org.apache.xmlrpc.XmlRpcHandler getHandler(String handlerName) throws XmlRpcNoSuchHandlerException, XmlRpcException {
                    //How to access handlerName the correct way?
//                    switch (handlerName) {
//                        case "sample":
//                            //handler here?
//                    }
                    XmlRpcHandler handler = new XmlRpcHandler() {
                        @Override
                        public Object execute(XmlRpcRequest pRequest) throws XmlRpcException {
                            int p1 = (int) pRequest.getParameter(0);
                            int p2 = (int) pRequest.getParameter(1);
                            return serverApp.sum(p1, p2);
                        }
                    };
                    return handler;
                }
            });
            server.start();

            System.out.println("Started successfully.");
            System.out.println("Accepting requests. (Halt program to stop.)");

        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }

    }

}
