package fi.tuni.prog3.sevenzipsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.compress.archivers.sevenz.SevenZArchiveEntry;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;


/**
 *
 * @author Eppuh
 */
public class Sevenz {

    public static void main(String[] args) throws IOException {
        try (SevenZFile sevenZFile = new SevenZFile(new File(args[0]))){
            Iterable<SevenZArchiveEntry> ze = sevenZFile.getEntries();
            
            // iterate through 7z contents
            for (var file : ze) {
                
                // check if file is a txt file
                if (file.getName().substring(file.getName().lastIndexOf(".") + 1).contains("txt")) {
                    System.out.println(file.getName());
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(sevenZFile.getInputStream(file)))) {
                        String line = br.readLine();
                        int lineNum = 1;
                        while (line != null) {
                            String printLine = findInLine(line, args[1]);
                            if (printLine != null) {
                                System.out.println(lineNum + ": " + printLine);
                            }
                            lineNum++;
                            line = br.readLine();
                        }
                        
                        br.close();
                        System.out.println("");
                    }
                }
            }
        } catch (IOException E) {
            System.out.println("Failed to open file");
        }
    }


    static String findInLine(String originalLine, String word) {
        originalLine = originalLine.toLowerCase();
        word = word.toLowerCase();
        if (!originalLine.contains(word)) {
            return null;
        }
        int i = 0;
        String newLine = originalLine;
        while (originalLine.indexOf(word, i) >= 0) {
            int startI = originalLine.indexOf(word, i);
            
            newLine = originalLine.substring(0, startI)
                    + originalLine.substring(startI, startI + word.length()).toUpperCase()
                    + originalLine.substring(startI + word.length());
            
            i = startI + word.length();
        }
        return newLine;
    }

}