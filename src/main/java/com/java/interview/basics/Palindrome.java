package com.java.interview.basics;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Hello , Ajay? Is this: environment"));
    }

    public static boolean isPalindrome(String string) {

       String s = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}
