package com.theaemogie.learnmod.util;

import java.util.Arrays;
import java.util.List;

import static com.theaemogie.learnmod.util.StringModifier.modifyString;

public class LoggerFormat {
    List<String> input;
    String output;

    public LoggerFormat(String... input) {
        this.input = Arrays.asList(input);
        processOutput(this.input);
    }

    public static String wrap(String input) {
        return modifyString("[learn-mod]:" + input, 35, 1);
    }

    private void processOutput(List<String> input) {
        String process = "";
        for (String str : input) {
            process = process.concat(str + "");
        }
        this.output = wrap(process);
    }

    public String get() {
        return this.output;
    }
}