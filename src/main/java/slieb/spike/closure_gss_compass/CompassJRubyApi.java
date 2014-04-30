package slieb.spike.closure_gss_compass;


import com.google.common.collect.ImmutableList;
import org.jruby.Ruby;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

import java.io.File;

import static org.jruby.javasupport.JavaEmbedUtils.initialize;
import static org.jruby.javasupport.JavaUtil.convertJavaToRuby;

public class CompassJRubyApi {

    private static final ImmutableList<String> LOAD_PATHS =
            new ImmutableList.Builder<String>()
                    .add("classpath:gems/sass-3.2.7/lib")
                    .add("classpath:gems/compass-0.12.2/lib")
                    .add("classpath:lib")
                    .build();

    private final Ruby runtime;

    private final IRubyObject compassApi;

    public CompassJRubyApi() {
        this.runtime = initialize(LOAD_PATHS);
        this.load();
        this.compassApi = runtime.evalScriptlet("SassCompilerApi.new");
    }

    public void load() {
        runtime.getLoadService().require("sass");
        runtime.getLoadService().require("sass/plugin");
        runtime.getLoadService().require("compass");
        runtime.getLoadService().require("compass_ext");
    }

    public void setOption(String key, Object value) {
        compassApi.callMethod(runtime.getCurrentContext(), "set", new IRubyObject[]{
                convertJavaToRuby(runtime, key),
                convertJavaToRuby(runtime, value)});
    }

    public void setImporter(File directory) {
        compassApi.callMethod(runtime.getCurrentContext(), "setImporterDirectory",
                convertJavaToRuby(runtime, directory.getAbsolutePath()));
    }

    public String compile(String input) {
        ThreadContext currentContext = runtime.getCurrentContext();
        IRubyObject inputRubyString = convertJavaToRuby(runtime, input);
        IRubyObject result = compassApi.callMethod(currentContext, "compile", inputRubyString);
        return (String) result.toJava(String.class);
    }

}
