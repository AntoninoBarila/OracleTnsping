package it.antoninobarila.main;

import java.io.*;
import java.util.Properties;

/**
 * This class stores the application's version.
 *
 * @author Anderson Bestteti Santos
 */
public final class ApplicationDetails {
    private final Properties properties;

    public ApplicationDetails() throws IOException {
        String propertyFileName = "pom.properties";
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        try {
            this.properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

    public String info() {
        return  getProperty("project.name") + " Version " + getProperty("project.version") + ": "+getProperty("project.description");
    }
}