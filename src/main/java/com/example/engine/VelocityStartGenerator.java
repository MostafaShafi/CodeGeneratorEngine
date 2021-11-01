package com.example.engine;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class VelocityStartGenerator {
    static String inputTemplate = "vtemplates/java_example.vm";
    static String className = "VelocityExample1";
    static String message = "Hello World!";
    static String outputFile = className + ".java";

    public static void main(String[] args) throws IOException {

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("className", className);
        context.put("message", message);

        Writer writer = new FileWriter(new File(outputFile));
        velocityEngine.mergeTemplate(inputTemplate, "UTF-8", context, writer);
        writer.flush();
        writer.close();

        System.out.println("Generated " + outputFile);
    }
}
