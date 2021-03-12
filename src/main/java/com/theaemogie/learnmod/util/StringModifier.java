package com.theaemogie.learnmod.util;

import java.util.ArrayList;

public class StringModifier {
    String modifier;
    String input;
    String output;

    /**
     * @param modifiers For possible modifiers, visit
     *                  <a href=https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html> this webpage.</a>
     */
    public String modifyString(String input, int... modifiers) {
        if (modifiers == null) {
            modifiers = new int[]{35, 1};
            System.out.println(input + " had no modifiers.");
        }
        ArrayList<String> modifier = new ArrayList<>();
        for (int i : modifiers) {
            modifier.add(String.valueOf(i));
        }
        this.modifier = "\u001b[" + String.join(";", modifier) + "m";
        this.input = input;
        this.output = this.modifier + this.input + "\u001b[0m";
        return output;
    }

}
