package com.codegym.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Introducing properties

*/

public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        // Implement this method
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        try (FileInputStream fis = new FileInputStream(fileName)) {
            load(fis);
        }
        console.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        // Implement this method
        Properties propConfig = new Properties();
        for (Map.Entry<String, String> x : properties.entrySet()) {
            propConfig.setProperty(x.getKey(), x.getValue());
        }
        propConfig.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        // Implement this method
        Properties propConfig = new Properties();
        propConfig.load(inputStream);
        
        for (Map.Entry<Object, Object> x : propConfig.entrySet()) {
            propConfig.getProperty((String) x.getKey());
            properties.put((String) x.getKey(), (String) x.getValue());
        }

    }

    public static void main(String[] args) {

    }
}
