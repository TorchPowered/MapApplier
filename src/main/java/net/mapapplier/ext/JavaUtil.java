package net.mapapplier.ext;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Utilities built using Java to ensure safe execution.
 *
 * @since 1.0-SNAPSHOT
 * @author PizzaCrust
 */
public class JavaUtil {
    /**
     * Retrieves all classes inside of a JAR.
     *
     * @param jarName the jar
     * @return the classes
     * @throws Exception if something goes wrong
     */
    public static String[] getAllClasses(File jarName) throws Exception {
        JarInputStream input = new JarInputStream(new FileInputStream(jarName));
        JarEntry jarEntry;

        ArrayList<String> classNames = new ArrayList<String>();

        while (true) {
            jarEntry = input.getNextJarEntry();
            if (jarEntry == null) {
                break;
            }
            if (jarEntry.getName().endsWith(".class")) {
                String className = jarEntry.getName().substring(0, jarEntry.getName().lastIndexOf('.'));
                className = className.replace('/', '.');
                classNames.add(className);
            }
        }

        return classNames.toArray(new String[classNames.size()]);
    }
}
