package com.aoop.skillprobem4;

class Main {
    public static <T extends Number> T findPalindrome(T num) {
        String str = num.toString();
        String reverse = new StringBuilder(str).reverse().toString();
        return (T) new Integer(Integer.parseInt(reverse));
    }

    public static void main(String[] args) {
        int num = 32468;
        int palindrome = findPalindrome(num);
        System.out.println("Palindrome of " + num + " is " + palindrome);
    }
}

