package com.host.singleton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CustomClassLoader extends ClassLoader {
	public CustomClassLoader(ClassLoader parent) {
        super(parent);
	}
	public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("com.host.singleton.Singleton")) {
            return findClass(name);
        }
        return super.loadClass(name);
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals("com.host.singleton.Singleton")) {
            try {
                byte[] classBytes = loadClassData(name);
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (Exception e) {
                throw new ClassNotFoundException("Could not load class data");
            }
        }
        return super.findClass(name);
    }


    private byte[] loadClassData(String className) {
        // Load class data from a file or a database or a network stream, etc.
        // Return the byte array containing the class data.
    	String fileName = "target/classes/"+className.replace('.', '/') + ".class";
        Path path = Paths.get(fileName);
        try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}
