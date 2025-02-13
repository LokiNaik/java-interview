package com.java.interview.basics;

public class GarbageCollection {
    public static void main(String[] args) {
        GarbageCollection gC = new GarbageCollection();
        gC = null; // eligible for GC
        System.gc(); // suggest GC.
    }
}
