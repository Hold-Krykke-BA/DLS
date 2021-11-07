package com.example.xmlrpc;


import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URL;
import java.util.Vector;


@SpringBootApplication
public class Client {

    public static void main(String[] args) {

        SpringApplication.run(Client.class, args);

        try {
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost/RPC2"));

            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);


            Vector params = new Vector();
            int element1 = 200;
            int element2 = 50;

            params.addElement(element1);
            params.addElement(element2);

            Object result = client.execute("sample.sum", params);

            int sum = ((Integer) result).intValue();
            System.out.println("The sum is: " + sum);

        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception);
        }
    }

}
