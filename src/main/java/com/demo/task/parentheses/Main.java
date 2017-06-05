package com.demo.task.parentheses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Task 1. Find the number of correct parenthesized expressions, which containing N opening and N closing brackets.
 * N is entered from the keyboard. N is a nonnegative integer.
 * @author Slavik Aleksey V.
 * @version 1.0
 */
public class Main {

    /**
     * Entry point in app
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //reader for getting data from keyboard
        System.out.print("Enter N: ");
        int n = Integer.parseInt(reader.readLine()); //get N
        HashSet<String> set = generate(n); //get generated set of correct parenthesized expressions
        for (String item : set)
            System.out.println(item); //output of generated set of correct parenthesized expressions
        System.out.println("Count:" + set.size());
    }

    /**
     * Methos generate set of correct parenthesized expressions
     * @param count
     * @return set of correct parenthesized expressions
     */
    private static HashSet<String> generate(int count) {
        HashSet<String> set = new HashSet<String>();
        if (count == 0) {
            set.add("");
        } else {
            HashSet<String> prev = generate(count - 1); // recursive call of method
            for (String s : prev) {
                for (int i = 0; i < s.length(); i++)
                    if (s.charAt(i) == '(')
                        set.add(insert(s, i)); // for every left bracket in string insert left and right brackets
                if (!set.contains("()" + s))
                    set.add("()" + s); // add left and right brackets to begin of string, because its variant not getting in previous step
            }
        }
        return set;
    }

    /**
     * Method inserted left and right brackets to string s after index
     * @param s
     * @param index
     * @return
     */
    private static String insert(String s, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, index + 1)); // substring left part of string
        sb.append("()");
        sb.append(s.substring(index + 1, s.length())); // substring right part of string
        return sb.toString();
    }
}
