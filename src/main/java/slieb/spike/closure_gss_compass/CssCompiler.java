package slieb.spike.closure_gss_compass;


import java.io.Reader;
import java.io.Writer;
import java.util.List;

public interface CssCompiler {
    public void compile(Reader reader, Writer writer);

    public String compile(List<String> inputStrings);
}
