package io.github.aemogie.learnmod.util;

import joptsimple.internal.Strings;

import static io.github.aemogie.learnmod.util.StringModifier.modifyString;

public class LoggerFormat {
	String output;
	
	public LoggerFormat(String... input) {
		this.output = wrap(Strings.join(input, " "));
	}
	
	public static String wrap(String input) {
		return modifyString("[learn-mod]: " + input);
	}
	
	@Override
	public String toString() {
		return output;
	}
}