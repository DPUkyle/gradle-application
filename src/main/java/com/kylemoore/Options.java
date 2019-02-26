package com.kylemoore;

import com.beust.jcommander.Parameter;

public class Options {
    @Parameter(names = {"--dependency", "-d"}, required = true)
    private String dependency;

    @Parameter(names = {"--help", "-h"}, help = true)
    private boolean help;

    public String getDependency() {
        return dependency;
    }

    public boolean isHelp() {
        return help;
    }
}
