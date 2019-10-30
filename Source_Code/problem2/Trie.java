//package com.priyanshu.unscrambleword;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.lang.*;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    void insert(String s) {
        Node it = root;
        for (int i = 0; i < s.length(); i++) {
            if (!it.children.containsKey(s.charAt(i))) {
                it.children.put(s.charAt(i), new Node());
            }
            it = it.children.get(s.charAt(i));
        }
        it.isWordEnd = true;
    }

    void printUnscrambles(String s) {
        if (s.length() < 1) {
            System.out.println();
            return;
        }
        for (int len = s.length(); len > 3; len--) {
            printUtil(s, new char[s.length()], root, len, 0);
            System.out.println("For length = " + len + " Count = " + count);
            count = 0;
        }
    }
    int count = 0;

    private void printUtil(final String s, char[] genString, Node n, int len, int index) {
        if (index == len) {
            if (n.isWordEnd) {
                System.out.println(genString);
                count++;
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (n.children.containsKey(s.charAt(i)) && !arrayContains(genString, s.charAt(i), index - 1)) {
                genString[index] = s.charAt(i);
                printUtil(s, genString, n.children.get(s.charAt(i)), len, index + 1);
            }
        }
    }

    private boolean arrayContains(char[] s, char c, int end) {
        for (int i = 0; i <= end; i++) {
            if (c == s[i]) {
                return true;
            }
        }
        return false;
    }
}

class Node {

    Map<Character, Node> children;
    boolean isWordEnd;
    String data;

    Node() {
        isWordEnd = false;
        children = new HashMap<>();
    }
}
