package com.theaemogie.learnmod.util;

import java.util.ArrayList;

public class StringModifier {

    /**
     * @param modifiers For possible modifiers, visit
     *                  <a href=https://www.lihaoyi.com/post/BuildyourownCommandLinewithANSIescapecodes.html> this webpage.</a>
     */
    public static String modifyString(String input, int... modifiers) {

        //FIXME Make it so that this method applies "default" modifiers when there are none.
        if (modifiers == null) {
            modifiers = new int[]{35, 1};
            System.out.println(input + " had no modifiers.");
        }

        ArrayList<String> modifier = new ArrayList<>();
        for (int i : modifiers) {
            modifier.add(String.valueOf(i));
        }
        String modifierString = "\u001b[" + String.join(";", modifier) + "m";
        String output = modifierString + input + "\u001b[0m";
        return output;
    }

}
