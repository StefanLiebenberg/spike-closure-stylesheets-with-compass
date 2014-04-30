package slieb.spike.closure_gss_compass;


import com.google.common.collect.ImmutableList;
import com.google.common.io.Files;
import org.jruby.Ruby;

import java.io.File;

import static org.jruby.javasupport.JavaEmbedUtils.initialize;

public class CompassJRubyApi {

    private static final ImmutableList<String> LOAD_PATHS =
            new ImmutableList.Builder<String>()
                    .add("classpath:gems/sass-3.2.7/lib")
                    .add("classpath:gems/compass-0.12.2/lib")
                    .build();

    private final Ruby runtime;

    private final File workingDirectory;

    private final File sourceDirectory;
    private final File outputDirectory;


    public CompassJRubyApi(File sourceDirectory, File outputDirectory) {
        this.runtime = initialize(LOAD_PATHS);
        this.sourceDirectory = sourceDirectory;
        this.outputDirectory = outputDirectory;
        this.workingDirectory = Files.createTempDir();
        this.workingDirectory.deleteOnExit();
    }

    public void load() {
        runtime.getLoadService().require("sass");
        runtime.getLoadService().require("sass/plugin");
        runtime.getLoadService().require("compass");
    }

    public String getOptions() {
        return String.format("{:time => true, :sass => Compass.sass_engine_options}");
    }

    public void compile() {
        runtime.evalScriptlet(
                String.format("Compass::Compiler.new('%s', '%s', '%s', %s).run",
                        this.workingDirectory.getAbsolutePath(),
                        this.sourceDirectory.getAbsolutePath(),
                        this.outputDirectory.getAbsolutePath(),
                        getOptions()));

    }
}
