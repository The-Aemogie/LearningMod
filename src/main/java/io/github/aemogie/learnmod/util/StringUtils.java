package io.github.aemogie.learnmod.util;

import joptsimple.internal.Strings;

import java.util.Arrays;

import static io.github.aemogie.learnmod.References.MOD_ID;

public class StringUtils {
	
	public static final String RESET = "\u001b[0m";
	public static final String BOLD = "\u001b[1m";
	
	public static final String BLACK = "\u001b[30m";
	public static final String RED = "\u001b[31m";
	public static final String GREEN = "\u001b[32m";
	public static final String YELLOW = "\u001b[33m";
	public static final String BLUE = "\u001b[34m";
	public static final String MAGENTA = "\u001b[35m";
	public static final String CYAN = "\u001b[36m";
	public static final String WHITE = "\u001b[37m";
	
	public static String fs(Object input, String... modifiers) {
		return formatString(input, modifiers);
	}
	
	public static String fs(String input, String... modifiers) {
		return formatString(input, modifiers);
	}
	
	public static String formatString(Object input, String... modifiers) {
		return formatString(String.valueOf(input), modifiers);
	}
	
	/**
	 * @param modifiers For possible modifiers, visit
	 *                  <a href=https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html> this webpage.</a>
	 */
	public static String formatString(String input, String... modifiers) {
		
		if (modifiers.length == 0) {
			modifiers = new String[]{MAGENTA, BOLD};
		}
		
		return Strings.join(modifiers, "") + input + RESET;
	}
	
	public static class LoggerMessage {
		String output;
		
		public LoggerMessage(String... input) {
			this.output = wrap(Strings.join(input, ""));
		}
		
		public LoggerMessage(Object... input) {
			this(Arrays.stream(input).map(Object::toString).toArray(String[]::new));
		}
		
		public static String wrap(String input) {
			return formatString("[" + MOD_ID + "]: " + input);
		}
		
		@Override
		public String toString() {
			return output;
		}
	}
}
