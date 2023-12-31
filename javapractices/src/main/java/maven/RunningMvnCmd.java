package maven;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.apache.maven.shared.invoker.*;

public class RunningMvnCmd {

    public static void main(String[] args) throws MavenInvocationException {
        runMvnCmd();
    }

    public static void runMvnCmd() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setBaseDirectory(new File("/Users/sjari/projects/RUGS/endpointSample/"));
        request.setGoals(Collections.singletonList("org.apache.maven.plugins:maven-archetype-plugin:3.0.0:generate"));
        request.setInteractive(false);
        Properties properties = new Properties();
        properties.setProperty("groupId", "com.paypal.risk.endpoint");
        properties.setProperty("artifactId", "sample");
        properties.setProperty("archetypeVersion", "1.0-SNAPSHOT");
        properties.setProperty("archetypeGroupId", "com.paypal.risk.gateway");
        properties.setProperty("archetypeArtifactId", "rugsendpoint-archetype");
        request.setProperties(properties);
        Invoker invoker = new DefaultInvoker();

        invoker.setMavenHome( new File("/usr/local/apache-maven-3.6.3"));

        //check maven home

//        String m2_home = System.getenv("M2_HOME");
//        if(null == m2_home)
//        {
//
//        }
//
//
//        invoker.setMavenHome( new File(System.getenv("MAVEN_HOME")));
        InvocationResult result = invoker.execute(request);
    }


}
