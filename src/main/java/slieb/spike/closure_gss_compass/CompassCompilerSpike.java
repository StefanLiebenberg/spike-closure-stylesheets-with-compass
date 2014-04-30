package slieb.spike.closure_gss_compass;


import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class CompassCompilerSpike implements CssCompiler {

    private final CompassJRubyApi compassJRubyApi;

    public CompassCompilerSpike(CompassJRubyApi compassJRubyApi) {
        this.compassJRubyApi = compassJRubyApi;
    }

    @Override
    public void compile(Reader reader, Writer writer) {

    }

    @Override
    public String compile(List<String> inputStrings) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
