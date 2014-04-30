package slieb.spike;


import com.google.common.io.Files;
import slieb.spike.closure_gss_compass.CompassJRubyApi;

import java.io.File;
import java.nio.charset.Charset;

public class JRubyRunner {
    public static void main(String[] args) throws Exception {
        File inputDirectory = new File("src/test/resources/sass");
//        File outputDirectory = Files.createTempDir();
//        outputDirectory.deleteOnExit();
        File outputDirectory = new File("target/sass-output");
        outputDirectory.mkdirs();
        CompassJRubyApi api = new CompassJRubyApi();
        File inputFile = new File("src/test/resources/sass/CompassImportExample.sass");
        String inputContent = Files.toString(inputFile, Charset.defaultCharset());
        api.setOption("filename", inputFile.getPath());
        api.setOption("css_filename", inputFile.getPath() + ".css");
        api.setImporter(inputDirectory);
        System.out.println(api.compile(inputContent));
    }
}