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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReposServiceGenerator {
    static String serviceInputTemplate = "vtemplates/Service.vm";
    static String repositoryInputTemplate = "vtemplates/Repository.vm";
    static String controllerInputTemplate = "vtemplates/Controller.vm";
    static String modelInputTemplate = "vtemplates/Model.vm";
    static String className = null;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        className = in.nextLine();

        List<Field> properties = new ArrayList<>();
        String input = null;
        while (true) {
            input = in.nextLine();
            if (!input.isEmpty() && input.equals("exit"))
                break;
            String s[] = input.split(" ");
            properties.add(new Field(s[1], s[0]));
        }
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        VelocityContext context = new VelocityContext();
        context.put("className", className);

        Writer serviceWriter = new FileWriter(new File("output/" + className + "Service.java"));
        velocityEngine.mergeTemplate(serviceInputTemplate, "UTF-8", context, serviceWriter);
        serviceWriter.flush();
        serviceWriter.close();

        Writer repositoryWriter = new FileWriter(new File("output/" + className + "Repository.java"));
        velocityEngine.mergeTemplate(repositoryInputTemplate, "UTF-8", context, repositoryWriter);
        repositoryWriter.flush();
        repositoryWriter.close();

        Writer controllerWriter = new FileWriter(new File("output/" + className + "Controller.java"));
        velocityEngine.mergeTemplate(controllerInputTemplate, "UTF-8", context, controllerWriter);
        controllerWriter.flush();
        controllerWriter.close();

        context.put("properties", properties);

        Writer modelWriter = new FileWriter(new File("output/" + className + ".java"));
        velocityEngine.mergeTemplate(modelInputTemplate, "UTF-8", context, modelWriter);
        modelWriter.flush();
        modelWriter.close();
        System.out.println(repositoryWriter.toString());
    }
}
