//package com.priyanshu.unscrambleword;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

public class UnscrambleWord {

    public static void main(String[] args) {
        Trie trie = new Trie();
        try {
            insertData(trie);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        trie.printUnscrambles("great");
    }

    static void insertData(Trie trie) throws FileNotFoundException {
        File file = new File("/usr/share/dict/words");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNext()) {
            trie.insert(fileScanner.next());
        }
    }

}
