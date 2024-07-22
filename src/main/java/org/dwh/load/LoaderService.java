package org.dwh.load;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class LoaderService {
    static final Logger log = LoggerFactory.getLogger(LoaderService.class);


    public static void loadFile(URL url, String fileName, String path) {
        Path outputPath = Path.of(path, fileName);

        try (InputStream in = url.openStream()) {
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
            log.info("Скачали файл с адреса:" + url);
        } catch (IOException e) {
            log.error("Ошибка при скачивание файла с адреса:" + url);
            throw new RuntimeException(e);
        }
    }
}
