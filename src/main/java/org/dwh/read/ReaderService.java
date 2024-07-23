package org.dwh.read;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.dwh.store.EntityExample;
import org.dwh.store.EntityExampleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    static final Logger log = LoggerFactory.getLogger(ReaderService.class);

    public void readOneLineByOne(String path, String fileName) {

        Path outputPath = Path.of(path, fileName);

        try (BufferedReader reader = Files.newBufferedReader(outputPath)) {
            CSVReader csvReader = new CSVReader(reader);
            String[] line;
            csvReader.readNext(); // skip header
            while ((line = csvReader.readNext()) != null) {
                if (line[0].isBlank() || line[0].isEmpty()) {
                    continue; // skip empty line
                }
                String[] row = line[0].split(";");
                System.out.println(Arrays.toString(row));
                log.info("Сохранение в БД");
                EntityExample example = new EntityExample(row);
                repository.save(example);
            }


        } catch (IOException | CsvValidationException e) {
            log.error("Ошибка при чтении файла: " + fileName);
        }

    }
}
