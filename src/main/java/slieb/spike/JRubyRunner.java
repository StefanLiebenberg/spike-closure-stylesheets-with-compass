package slieb.spike;


import com.google.common.io.Files;
import slieb.spike.closure_gss_compass.CompassJRubyApi;

import java.io.File;

public class JRubyRunner {
    public static void main(String[] args) {
        File inputDirectory = new File("src/test/resources/sass");
//        File outputDirectory = Files.createTempDir();
//        outputDirectory.deleteOnExit();
        File outputDirectory = new File("target/sass-output");
        outputDirectory.mkdirs();
        CompassJRubyApi api = new CompassJRubyApi(inputDirectory, outputDirectory);
        api.load();
        api.compile();
    }
}
