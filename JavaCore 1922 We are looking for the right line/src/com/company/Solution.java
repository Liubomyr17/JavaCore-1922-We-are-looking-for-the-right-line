package com.company;

/*

1922 We are looking for the right line
Read the file name from the console.
Print to the console all lines from the file that contain only 2 words from the words list.
Close streams.
Example:
words contains the words A, B, C
Rows:
In B A D // 3 words from words, not suitable
Y A D // 1 word from words, not suitable
D A B D // 2 words - suitable, output

Requirements:
1. The Solution class should contain a public static field of words of type List, which should be immediately initialized.
2. The Solution class must contain a static block in which three words are added to the words list.
3. The program should read the file name from the console (use BufferedReader).
4. BufferedReader for reading data from the console should be closed.
5. The program should read the contents of the file (use FileReader).
6. The stream of reading from the file (FileReader) should be closed.
7. The program should print to the console all lines from the file that contain only 2 words from the words list.


*/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Solution {

    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = conReader.readLine();
        //String fileName = "e:\\11.txt";
        conReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] lineWords = line.split("[\\p{P}\\s\\t\\n\\r]");
            int count = 0;
            for (String lineWord : lineWords) {
                for (String word : words) {
                    if (lineWord.trim().equals(word))
                        count += 1;
                }
            }
            if (count == 2)
                System.out.println(line);
        }
        fileReader.close();
    }
}
