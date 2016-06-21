package com.adatar.resourceloader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileLoader {

    public static ArrayList<String> readFile(String file)  throws IOException {

        ArrayList<String> lines = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        for (String line; (line = br.readLine()) != null; ) {
            lines.add(line);
        }

        br.close();
        return lines;
    }
}
