package org.dwh.load;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.dwh.store.EntityExampleRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class LoaderService {


    public static void loadFile(URL url, String fileName, String path) {
        Path outputPath = Path.of(path, fileName);

        try (InputStream in = url.openStream()) {
            Files.copy(in, outputPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
