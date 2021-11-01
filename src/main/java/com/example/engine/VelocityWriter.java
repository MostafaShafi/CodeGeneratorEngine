package com.example.engine;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityWriter {
 
    static String modelName = "User";
    static String packageName = "com.example.engine";
    static String inputTemplate = "vtemplates/Model.vm";
 
    public static void main(String[] args) throws IOException {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();
      
        Template t = velocityEngine.getTemplate(inputTemplate);
       
        VelocityContext context = new VelocityContext();
  
        if(packageName != null) {
            context.put("packagename", packageName);
        }
  
        List<Field> properties = new ArrayList<>();
        properties.add(new Field("id", "int"));
        properties.add(new Field("firstName", "String"));
        properties.add(new Field("lastName", "String"));
        properties.add(new Field("dob", "LocalDate"));
        context.put("className", "VelocityExample");
        context.put("properties", properties);
  
        StringWriter writer = new StringWriter();
        t.merge( context, writer );

        Writer writer1 = new FileWriter(new File("VelocityExample.java"));
        velocityEngine.mergeTemplate(inputTemplate, "UTF-8", context, writer1);
        writer1.flush();
        writer1.close();
        System.out.println(writer.toString());
    }
}