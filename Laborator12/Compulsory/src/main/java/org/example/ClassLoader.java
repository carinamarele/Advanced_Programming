package org.example;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author Marele Carina-Ioana 2A4
 */
public class ClassLoader extends URLClassLoader{
    public ClassLoader() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
    }

    @Override
    public void addURL(URL url) {
        super.addURL(url);
    }

}