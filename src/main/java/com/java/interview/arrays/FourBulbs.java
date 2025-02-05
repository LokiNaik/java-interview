 package com.java.interview.arrays;

import java.util.Arrays;

/**
 * four bulbs are there and 3 colors say red, blue and green.
 * In each iteration assign one color to one of the bulb from left.
 * then in iteration 2,shift everything right and assign other color to the bulb at left and so on...
 */
public class FourBulbs {
    public static void main(String[] args) {
        String[] colours = {"Red", "Blue", "Green"};
        String[] bulbs = new String[4];
        for (int i = 0; i < colours.length; i++) {
            // Inner loop is for shifting the bubls elements to right.
            for (int j = bulbs.length - 1; j > 0; j--) {
                bulbs[j] = bulbs[j - 1];
            }
            bulbs[0] = colours[i]; // assigning the 0th element of bulb with colour[i]
            // Print the bulbs' colors in this iteration
            System.out.println("Iteration " + (i + 1) + ": " + Arrays.toString(bulbs));
        }
    }
}
