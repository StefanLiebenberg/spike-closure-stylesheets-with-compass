package slieb.spike;


import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;

import java.util.ArrayList;
import java.util.List;

public class JRubyRunner {
    public static void main(String[] args) {
        List paths = new ArrayList();
        paths.add("classpath:gems/compass-0.12.2/lib");
        Ruby ruby = JavaEmbedUtils.initialize(paths);
        ruby.getLoadService().require("compass");
        Object compass = ruby.evalScriptlet("puts ");
    }
}
