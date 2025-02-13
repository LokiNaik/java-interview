package com.java.interview.stringmanuplations;

import java.util.Arrays;

public class StringManipulationUsingStreams {
    public static void main(String[] args) {
        System.out.println(reverseStringUsingLoop("Hello World"));
        System.out.println(reverseStringUsingStringBuilder("Hello World!"));
        System.out.println(isAnagram("Hello", "World"));
        System.out.println(isAnagram("Listen", "silent"));
        System.out.println(occurrenceOfChar("Hello world", 'o'));
    }

    public static String reverseStringUsingLoop(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static String reverseStringUsingStringBuilder(String s) {
        StringBuilder reversed = new StringBuilder(s);
        return reversed.reverse().toString();
    }

    public static boolean isAnagram(String s, String t) {
        String sLowerCase = s.toLowerCase();
        String tLowerCase = t.toLowerCase();
        char[] string1 = sLowerCase.toCharArray();
        char[] string2 = tLowerCase.toCharArray();
        Arrays.sort(string1);
        Arrays.sort(string2);
        return Arrays.equals(string1, string2);
    }

    public static int occurrenceOfChar(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }
}
