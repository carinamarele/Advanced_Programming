package org.example;

import annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;


/**
 *
 * @author Marele Carina-Ioana 2A4
 */
public class App{
    public static void main( String[] args ) throws Exception
    {
        ClassLoader chargerClass = new ClassLoader();
        int passed = 0;
        int failed = 0;


        String pathForClass = "D:/Laborator12/Compulsory/src/main/java/UserController.class";
        System.out.println("The path for the class: " + pathForClass);


        File pathClass = new File(pathForClass);
        if (pathClass.exists()) {
            URL urlClass = pathClass.toURI().toURL();
            chargerClass.addURL(urlClass);
        }

        for (Method methodClass : chargerClass.loadClass("org.example.TestClass").getMethods()) {
            if (methodClass.isAnnotationPresent(Test.class)) {
                try {
                    methodClass.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed at %s  with %n", methodClass, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Total passed: %d, Total failed %d%n", passed, failed);
    }

}
