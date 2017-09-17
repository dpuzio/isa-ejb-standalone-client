package com.isa.javaeebasics.randomgenerator.client;

import com.isa.javaeebasics.randomgenerator.ejb.RemoteNumbersGenerator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class App {
    public static void main(String[] args) throws NamingException {

        Hashtable<String, String> properties = new Hashtable<String, String>();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context","true");
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
        properties.put(Context.SECURITY_PRINCIPAL, "test");
        properties.put(Context.SECURITY_CREDENTIALS, "test123");
        Context context = new InitialContext(properties);

        RemoteNumbersGenerator generator =
                        (RemoteNumbersGenerator) context.lookup("random-generator/NumbersGenerator!com.isa.javaeebasics.randomgenerator.ejb.RemoteNumbersGenerator");
        System.out.println(generator.getRandomInt(10));
    }
}
