package resourceloader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileLoader {

    public static ArrayList<String> readFile(String file)  throws FileNotFoundException, IOException {

        ArrayList<String> lines = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new FileReader(file));

        for (String line; (line = br.readLine()) != null; ) {
            lines.add(line);
        }

        return lines;
    }

}
