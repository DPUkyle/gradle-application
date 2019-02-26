package com.kylemoore;

import com.beust.jcommander.JCommander;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.Dependency;
import org.gradle.testfixtures.ProjectBuilder;

import java.io.File;
import java.util.Set;

public class App {

    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        Options options = new Options();
        JCommander help = JCommander.newBuilder().addObject( options ).args( args ).build();
        if( args.length == 0 || options.isHelp() ) {
            help.setProgramName( "gradle-application" );
            help.usage();
            System.exit( 0 );
        }

        new App().run(options);
    }

    public void run(Options options) {
        // TODO validation; check that paremeter is a GAV triplet

        Project project = ProjectBuilder.builder().build();

        project.getRepositories().jcenter();
        project.getRepositories().mavenCentral();

        Dependency dep = project.getDependencies().create(options.getDependency());
        Configuration detachedConfiguration = project.getConfigurations().detachedConfiguration(dep);

        Set<File> files = detachedConfiguration.resolve();

        System.out.println("Got files: ");
        files.forEach(System.out::println);

        System.exit(0);
    }

}
