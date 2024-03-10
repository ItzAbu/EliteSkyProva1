package org.itzabu.eliteskyprova1.utils;

public class ChatColor {
    public static String translateAlternateColorCodes(String textToTranslate) {
        if(textToTranslate == null) return null;
        char[] b = textToTranslate.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == '&' && "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(b[i + 1]) > -1) {
                b[i] = '§';
                b[i + 1] = Character.toLowerCase(b[i + 1]);
            }
        }

        return new String(b);
    }
}
