package org.dwh.read;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.dwh.store.EntityExample;
import org.dwh.store.EntityExampleRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class ReaderService {
    private final EntityExampleRepository repository;

    public void readOneLineByOne(String path, String fileName) {

        Path outputPath = Path.of(path, fileName);

        try (BufferedReader reader = Files.newBufferedReader(outputPath)) {
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            boolean flag = false;
            csvReader.readNext(); // skip header
            while ((line = csvReader.readNext()) != null) {
                String[] row = line[0].split(";");
                System.out.println(Arrays.toString(row));
                EntityExample example = new EntityExample(row);
                repository.save(example);
            }


        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }
}
