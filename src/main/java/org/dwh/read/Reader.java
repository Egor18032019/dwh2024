package org.dwh.read;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.dwh.store.MasterOfTables;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {

    public void readOneLineByOne(String path, String fileName) {
        MasterOfTables masterOfTables = new MasterOfTables();
        Path outputPath = Path.of(path, fileName);

        try (BufferedReader reader = Files.newBufferedReader(outputPath)) {
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            boolean flag = false;
            while ((line = csvReader.readNext()) != null) {
                String[] row = line[0].split(";");
                if (!flag) {
                    masterOfTables.createTable(fileName, row);
                    flag = true;
                } else {
                    masterOfTables.insertData(fileName, row);
                }
            }

            masterOfTables.close();
        } catch (IOException | CsvValidationException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
