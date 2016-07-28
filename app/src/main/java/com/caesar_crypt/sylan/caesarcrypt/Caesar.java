package com.caesar_crypt.sylan.caesarcrypt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Caesar {
    private static ArrayList<Character> ALPHABET;

    static {
        ArrayList<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < 26; i++) {
        	temp.add((char) ('A' + i));
        }
        ALPHABET = temp;
    }
    
    public static String encrypt(String text, int key) {
        if (key < 0) {
            return encryptGeneral(text);
        }
        text = text.toUpperCase();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (ALPHABET.contains(text.charAt(i))) {
                    result += ALPHABET.get((ALPHABET.indexOf(text.charAt(i)) 
                    		+ (26 - key)) % 26);
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }

    public static String encryptGeneral(String text) {
        String result = "";
        for (int i = 0; i < 26; i++) {
            result += "KEY: " + i + " - " + encrypt(text, i) + "\n";
        }
        return result;
    }

    public static String decrypt(String text, int key) {
        if (key >= 0) {
            return decryptSpecific(text, key);
        }
        String result = "";
        for (int i = 0; i < 26; i++) {
            result += "KEY: " + i + " - ";
            result += decryptHelper(text, i);
            result += "\n";
        }
        return result;
    }

    public static String decryptSpecific(String text, int key) {
        return decryptHelper(text, key);
    }

    private static String decryptHelper(String text, int key) {
        text = text.toUpperCase();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (ALPHABET.contains(text.charAt(i))) {
                    result += ALPHABET.get((ALPHABET.indexOf(text.charAt(i)) 
                    		+ key) % 26);
            } else {
                result += text.charAt(i);
            }
        }
        return result;
    }
}