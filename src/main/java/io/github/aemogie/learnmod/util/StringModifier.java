package io.github.aemogie.learnmod.util;

import joptsimple.internal.Strings;

public class StringModifier {
	
	public static final String BOLD = "\u001b[1m";
	public static final String BLACK = "\u001b[30m";
	public static final String RED = "\u001b[31m";
	public static final String GREEN = "\u001b[32m";
	public static final String YELLOW = "\u001b[33m";
	public static final String BLUE = "\u001b[34m";
	public static final String MAGENTA = "\u001b[35m";
	public static final String CYAN = "\u001b[36m";
	public static final String WHITE = "\u001b[37m";
	public static final String RESET = "\u001b[0m";
	
	/**
	 * @param modifiers For possible modifiers, visit
	 *                  <a href=https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html> this webpage.</a>
	 */
	public static String modifyString(String input, String... modifiers) {
		
		if (modifiers.length == 0) {
			modifiers = new String[]{MAGENTA, BOLD};
		}
		
		String modifierString = Strings.join(modifiers, "");
		return modifierString + input + RESET;
	}
	
}
