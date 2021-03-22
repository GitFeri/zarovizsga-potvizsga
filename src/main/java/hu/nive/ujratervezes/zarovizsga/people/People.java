package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {
    public int getNumberOfMales(String fileName) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
            return countOfMaleOfLine(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private int countOfMaleOfLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        int result = 0;
        while ((line = reader.readLine()) != null) {
            result += setOneIfMale(line);
        }
        return result;
    }

    private int setOneIfMale(String line) {
        String[] splitedLine = line.split(",");
        if ("Male".equals(splitedLine[4])) {
            return 1;
        }
        return 0;
    }

}
