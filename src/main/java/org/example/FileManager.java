package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManager {

    public String readFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            for (String line : allLines) {
                contentBuilder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file at " + filePath, e);
        }
        return contentBuilder.toString();
    }

    public void writeFile(String content, String filePath) {
        try {
            Files.writeString(Paths.get(filePath), content, StandardOpenOption.CREATE,
                                                            StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file at " + filePath, e);
        }
    }
}
