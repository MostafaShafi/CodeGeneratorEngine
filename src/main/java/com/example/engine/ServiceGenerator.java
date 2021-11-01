package com.example.engine;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ServiceGenerator {
    static String packageName = "com.example.shesh.Services";
    static String inputTemplate = "vtemplates/Service.vm";
    static String className = null;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        className = in.nextLine();

        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        Template t = velocityEngine.getTemplate(inputTemplate);

        VelocityContext context = new VelocityContext();
        if(packageName != null) {
            context.put("packagename", packageName);
        }
        context.put("className", className);

        Writer writer = new FileWriter(new File(className + "Service.java"));
        velocityEngine.mergeTemplate(inputTemplate, "UTF-8", context, writer);
        writer.flush();
        writer.close();
        System.out.println(writer.toString());
    }
}
