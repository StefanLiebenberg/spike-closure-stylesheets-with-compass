package slieb.spike.closure_gss_compass;


import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class SpikeClosureGssCompassTest {
    CssCompiler compiler;

    public void setup() {
        compiler = null;
    }

    @Test
    public void testClosureGssCanCompileSass() {
        InputStream inputStream = getClass().getResourceAsStream("/sass/CompassImportExample.sass");
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        StringWriter stringWriter = new StringWriter();
        compiler.compile(inputStreamReader, stringWriter);
        String result = stringWriter.toString();

    }
}
