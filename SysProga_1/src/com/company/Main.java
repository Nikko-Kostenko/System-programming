package com.company;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String in = new Scanner(new FileReader("File_Path")).nextLine();
        int limit = 30;
        String subStr = in.length() > limit ? in.substring(0, limit) : in;
        String mainSub = subStr.replaceAll("[^A-Za-zА-Яа-я0-9 ]", " ");
        String[] m = mainSub.split(" ");
        Arrays.sort(m);

        String maxWord = "", word = "";
        int maxCount = 0, count = 1;

        for (String s : m) {
            if (s.equals(word)) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxWord = word;
                }
                word = s;
                count = 1;
            }
        }

        if (count > maxCount) {
            maxCount = count;
            maxWord = word;
        }
        if(maxCount == 1) {
            System.out.println("Нет слов, которые встречаются чаще всего");
        } else {
            System.out.println("Самое повторяющееся слово: " + maxWord + " (встречается " + maxCount + " раза)");
        }
    }
}